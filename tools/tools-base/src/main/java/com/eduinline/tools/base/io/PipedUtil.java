package com.eduinline.tools.base.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>管道通信工具类。由管道输入流连接一个管道输出流构成<B>管道</B>进行通信，为单向通信模式。</p>
 * <p>本工具类封装了双向管道通信:1.基于字节流的读写管道；2.基于字符的读写管道</p>
 * <ul>
 * 	<li>1.提供了管道工具类连接另一个管道的功能</li>
 * 	<li>2.提供了管道之间的双向通信功能</li>
 * 	<li>3.提供了包括基于字节流的通信(PipedInputStream和PipedOutputStream)和
 * 		基于字符的通信(PipedReader和PipedWriter)
 * 	</li>
 * 	<li>TODO </li>
 * </ul>
 *
 * @author hongze.he@eduinline.com
 * @version 1.0 2016年4月26日-下午9:41:39
 */
public class PipedUtil {
	/** 日志对象 */
	private static Logger logger = LoggerFactory.getLogger(PipedUtil.class);
	/** 基于字节流的读通道 */
	private PipedInputStream pis = new PipedInputStream();
	/** 基于字节流的写通道 */
	private PipedOutputStream pos = new PipedOutputStream();
	/** 基于字符的读通道 */
	private PipedReader pr = new PipedReader();
	/** 基于字符的写通道 */
	private PipedWriter pw = new PipedWriter();
	/** 进行对接的管道对象 */
	private PipedUtil toConnectPiped;
	/** 接收管道数据的处理器，启用独立线程处理，避免单线程读写管道造成死锁 */
	private PipedReceiveHandle pipedReceiveHandle;

	public static void main(String[] args) throws InterruptedException {
		PipedUtil p1 = new PipedUtil();
		PipedUtil p2 = new PipedUtil();
		p1.setPipedReceiveHandle(new PipedReceiveHandle() {
			@Override
			public void handleChar(char[] receiveData) {
				System.out.println("来自p2:"+new String(receiveData));
			}
			
			@Override
			public void handleByte(byte[] receiveData) {
				System.out.println("来自p2:"+new String(receiveData));
			}
		});
		p2.setPipedReceiveHandle(new PipedReceiveHandle() {
			@Override
			public void handleChar(char[] receiveData) {
				System.out.println("来自p1:"+new String(receiveData));
			}
			
			@Override
			public void handleByte(byte[] receiveData) {
				System.out.println("来自p1:"+"接收到字节数据啦。。。。");
			}
		});
		p1.setToConnectPiped(p2);
		p2.setToConnectPiped(p1);
		p2.connect();
		p1.connect();
		p2.sendByteData("p2-1".getBytes());
	}

	/**
	 * 进行连接操作。
	 */
	public boolean connect(){
		try{
			//1.启动发送方的发送处理线程
			pos.connect(toConnectPiped.getPis());
			pw.connect(toConnectPiped.getPr());
			//2.启动接收方的接收处理线程
			toConnectPiped.startListener();
			logger.info("管道连接成功");
			return true;
		}catch(IOException e){
			logger.error("管道连接异常", e);
			destroy();
			return false;
		}
	}
	
	/**
	 * 启动接收方接收数据的线程
	 * @return true=启动成功，否则失败
	 */
	public void startListener(){
		new Thread(new ByteReceiveHandle()).start();
		new Thread(new CharReceiveHandle()).start();
	}

	/**
	 * 销毁管道通道。
	 * @return true=销毁成功，否则失败
	 */
	public final boolean destroy(){
		try{
			if(null!=pos)
				pos.close();
			if(null!=pis)
				pis.close();
			if(null!=pw)
				pw.close();
			if(null!=pr)
				pr.close();
			if(null!=toConnectPiped){
				if(null!=toConnectPiped.getPos())
					toConnectPiped.getPos().close();
				if(null!=toConnectPiped.getPis())
					toConnectPiped.getPis().close();
				if(null!=toConnectPiped.getPw())
					toConnectPiped.getPw().close();
				if(null!=toConnectPiped.getPr())
					toConnectPiped.getPr().close();
			}
			logger.info("管道销毁成功");
			return true;
		}catch(IOException e){
			logger.error("管道销毁异常", e);
			return false;
		}
	}

	/**
	 * 发送字节数据
	 * @param sendData 需要发送的字节数组
	 * @return true=成功，否则失败
	 */
	public final boolean sendByteData(byte[] sendData){
		try{
			if(null==sendData || sendData.length == 0)
				return true;
			int dataLen = sendData.length;
			byte[] lenByte = intToByte(dataLen);
			pos.write(lenByte);
			pos.write(sendData);
			pos.flush();
			return true;
		}catch(IOException e){
			logger.error("发送字节数据异常", e);
			return false;
		}
	}

	/**
	 * 发送字符数据
	 * @param sendData 需要发送的字符
	 * @return true=成功，否则失败
	 */
	public final boolean sendCharData(String sendData){
		return sendCharData(sendData.toCharArray());
	}

	/**
	 * 发送字符数据
	 * @param sendData 需要发送的字符数组
	 * @return true=成功，否则失败
	 */
	public final boolean sendCharData(char[] sendData){
		try{
			if(null==sendData || sendData.length == 0)
				return true;
			int dataLen = sendData.length;
			char[] lenByte = intToChar(dataLen);
			pw.write(lenByte);
			pw.write(sendData);
			pw.flush();
			return true;
		}catch(IOException e){
			logger.error("发送字符数据异常", e);
			return false;
		}
	}
	
	/**
	 * <p>监听读取字节流的线程</p>
	 */
	class ByteReceiveHandle implements Runnable{
		byte[] byteTempData = new byte[4];
		@Override
		public void run() {
			while(true){
				try{
					int len = 0;
					if(pis.read(byteTempData)!=-1){
						len = byteToInt(byteTempData);
						byte[] receiveData = new byte[len];
						while(pis.read(receiveData)!=-1){
							break;
						}
						PipedReceiveHandle handle= 
								pipedReceiveHandle.getClass().newInstance();
						handle.setReceiveData(receiveData);
						new Thread(handle).start();
					}
				}catch(Exception e){
					logger.error("处理接收的字节数据异常", e);
					break;
				}
			}
		}
	}
	
	/**
	 * <p>监听读取字符的线程</p>
	 */
	class CharReceiveHandle implements Runnable{
		char[] charTempData = new char[2];
		@Override
		public void run() {
			while(true){
				try{
					int len = 0;
					if(pr.read(charTempData)!=-1){
						len = charToInt(charTempData);
						char[] receiveData = new char[len];
						while(pr.read(receiveData)!=-1){
							break;
						}
						PipedReceiveHandle handle= 
								pipedReceiveHandle.getClass().newInstance();
						handle.setReceiveData(receiveData);
						new Thread(handle).start();
					}
				}catch(Exception e){
					logger.error("处理接收的字符数据异常", e);
					break;
				}
			}
		}
	}

	/**
	 * 将整数转为4长度字节数组
	 * @param num 需要转换的整数
	 * @return 转换后的字节数组
	 */
	private final byte[] intToByte(int num){
		byte[] target = new byte[4];
		int length = target.length;
		for(int i=0; i<length; i++){
			target[i] = (byte) (num>>(24-8*i) & 0xff);
		}
		return target;
	}

	/**
	 * 将4长度字节数组转为整数
	 * @param src 需要转换的字节数组
	 * @return 转换后的整数
	 */
	private final int byteToInt(byte[] src){
		int a = 0;
		int length = src.length;
		for(int i=0; i<length; i++){
			a += (src[i] & 0xFF) << (24-8*i);
		}
		return a;
	}

	/**
	 * 将整数转为2长度字符数组
	 * @param num 需要转换的整数
	 * @return 转换后的字符数组
	 */
	private final char[] intToChar(int num){
		char[] target = new char[2];
		int length = target.length;
		for(int i=0; i<length; i++){
			target[i] = (char) (num>>(16-16*i) & 0xffff);
		}
		return target;
	}

	/**
	 * 将2长度字符数组转为整数
	 * @param src 需要转换的字符数组
	 * @return 转换后的整数
	 */
	private final int charToInt(char[] src){
		int a = 0;
		int length = src.length;
		for(int i=0; i<length; i++){
			a += (src[i] & 0xFFFF) << (16-16*i);
		}
		return a;
	}

	

	/**
	 * @return the pis
	 */
	public PipedInputStream getPis() {
		return pis;
	}
	/**
	 * @param pis the pis to set
	 */
	public void setPis(PipedInputStream pis) {
		this.pis = pis;
	}
	/**
	 * @return the pos
	 */
	public PipedOutputStream getPos() {
		return pos;
	}
	/**
	 * @param pos the pos to set
	 */
	public void setPos(PipedOutputStream pos) {
		this.pos = pos;
	}
	/**
	 * @return the pr
	 */
	public PipedReader getPr() {
		return pr;
	}
	/**
	 * @param pr the pr to set
	 */
	public void setPr(PipedReader pr) {
		this.pr = pr;
	}
	/**
	 * @return the pw
	 */
	public PipedWriter getPw() {
		return pw;
	}
	/**
	 * @param pw the pw to set
	 */
	public void setPw(PipedWriter pw) {
		this.pw = pw;
	}
	
	/**
	 * @return the toConnectPiped
	 */
	public PipedUtil getToConnectPiped() {
		return toConnectPiped;
	}
	/**
	 * @param toConnectPiped the toConnectPiped to set
	 */
	public void setToConnectPiped(PipedUtil toConnectPiped) {
		this.toConnectPiped = toConnectPiped;
	}

	/**
	 * @return the pipedReceiveHandle
	 */
	public PipedReceiveHandle getPipedReceiveHandle() {
		return pipedReceiveHandle;
	}

	/**
	 * @param pipedReceiveHandle the pipedReceiveHandle to set
	 */
	public void setPipedReceiveHandle(PipedReceiveHandle pipedReceiveHandle) {
		this.pipedReceiveHandle = pipedReceiveHandle;
	}

}


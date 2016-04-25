package com.eduinline.tools.base.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.MessageFormat;

/**
 * <p>com.helizfamily.tools.base.net.SocketBase.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年3月31日-下午3:11:04
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose 封装Socket的公共处理功能。
 */
public abstract class SocketAbs extends SocketBase{

	private static final String SEND = 
			"Socket发送消息异常.serverIP={0},serverPort={1},localIP={2},localPort={3}";

	private static final String RECEIVE = 
			"Socket读取消息异常.serverIP={0},serverPort={1},localIP={2},localPort={3}";

	private static final String CLOSE = 
			"Socket关闭异常.serverIP={0},serverPort={1},localIP={2},localPort={3}";

	/** 包装的Socket对象 */
	protected Socket socket;

	/** 连接上的输入流 */
	protected InputStream in = null;

	/** 连接上的输出流 */
	protected OutputStream out = null;

	/** 是否保持在线状态，即:使用后不关闭 */
	protected boolean keepOnLine = true;

	/**
	 * <p>通过Socket发送消息，发送前请判断{@link #out}是否为空</p>
	 * <ul>
	 * 	<li>第1步：得到标记内容长度的前4长度字节数组lenByte，并发送</li>
	 * 	<li>第2步：发送参数中的内容</li>
	 * </ul>
	 * @return 返回客户端发送的内容数组
	 */
	public final boolean sendData(byte[] sendData){
		try{
			if(null==sendData || sendData.length == 0)
				return true;
			int dataLen = sendData.length;
			byte[] lenByte = intToByte(dataLen);
			out.write(lenByte);
			out.write(sendData);
			out.flush();
			return true;
		}catch(IOException e){
			logger.error(logMessage(SEND), e);
			return false;
		}
	}

	/**
	 * <p>读取Socket套接字输入流中的字节信息</p>
	 * <ul>
	 * 	<li>第1步：读取标记内容长度的前4长度字节数组,得到内容长度的整数len</li>
	 * 	<li>第2步：根据第1步得到的内容长度，读取完整的内容数组receiveData</li>
	 * </ul>
	 * @return 返回客户端发送的内容数组
	 */
	public final byte[] receiveData(){
		try{
			byte[] tempData = new byte[4];
			int len = 0;
			if(in.read(tempData)!=-1){
				len = byteToInt(tempData);
			}else{
				return null;
			}
			byte[] receiveData = new byte[len];
			while(in.read(receiveData)!=-1){
				break;
			}
			return receiveData;
		}catch(IOException e){
			logger.error(logMessage(RECEIVE), e);
			return new byte[0];
		}
	}

	/**
	 * 关闭Socket连接
	 * @return true=成功关闭
	 * @throws IOException 
	 */
	public boolean close(){
		try{
			if (out!=null) {
				out.close();
				out=null;
			}
			if (in!=null) {
				in.close();
				in=null;
			}
			if (socket!=null) {
				socket.close();
				socket=null;
			}
			return true;
		}catch(IOException e){
			logger.error(logMessage(CLOSE));
			return false;
		}

	}

	/**
	 * 根据模式格式化日志信息
	 * @param pattern 模式字符串
	 * @return 格式化后的日志信息
	 */
	protected String logMessage(String pattern){
		String sIP = socket.getInetAddress().getHostAddress();
		int sPort = socket.getPort();
		String lIP = socket.getLocalAddress().getHostAddress();
		int lPort = socket.getLocalPort();
		return MessageFormat.format(pattern, sIP, sPort, lIP, lPort);
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
	 * @return the keepOnLine
	 */
	public boolean isKeepOnLine() {
		return keepOnLine;
	}

	/**
	 * @param keepOnLine the keepOnLine to set
	 */
	public void setKeepOnLine(boolean keepOnLine) {
		this.keepOnLine = keepOnLine;
	}

	/**
	 * @return the socket
	 */
	public Socket getSocket() {
		return socket;
	}

	/**
	 * @param socket the socket to set
	 * @throws IOException 
	 */
	public void setSocket(Socket socket) throws IOException {
		this.socket = socket;
		if(null==in)
			this.in = this.socket.getInputStream();
		if(null==out)
			this.out = this.socket.getOutputStream();
	}
	
}


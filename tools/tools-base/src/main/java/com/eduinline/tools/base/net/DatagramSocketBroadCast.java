package com.eduinline.tools.base.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.text.MessageFormat;

/**
 * <p>com.helizfamily.tools.base.net.DatagramSocketBroadCast.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年4月1日-下午2:32:22
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose 基于UDP协议进行广播的Socket套接字客户端。
 */
public class DatagramSocketBroadCast extends DatagramSocketAbs{

	/** DatagramSocket */
	protected DatagramSocket datagramSocket = null;
	
	/**
	 * 默认构造函数
	 */
	public DatagramSocketBroadCast(){
		super();
	}

	/**
	  * 根据目标地址和端口构造客户端
	  * @param toHost 数据报接收地址
	  * @param toPort 数据报接收端口
	  */
	public DatagramSocketBroadCast(String toHost, int toPort){
		this.toHost = toHost;
		this.toPort = toPort;
	}

	/**
	  * 根据目标地址和端口构造客户端，并绑定本地IP和端口
	  * @param toHost 数据报接收地址
	  * @param toPort 数据报接收端口
	  * @param localHost 本地主机地址
	  * @param localPort 本地端口
	  */
	public DatagramSocketBroadCast(String toHost, int toPort, String localHost, int localPort){
		this.toHost = toHost;
		this.toPort = toPort;
		this.localHost = localHost;
		this.localPort = localPort;
	}

	/**
	 * 注册客户端
	 */
	public void regist() throws IOException{
		if(this.datagramSocket == null || this.datagramSocket.isClosed() 
				|| !this.datagramSocket.isConnected()){
			//1.创建对象
			this.datagramSocket = new DatagramSocket(null);
			//2.设置配置参数
			this.datagramSocket.setBroadcast(broadcast);
			this.datagramSocket.setSoTimeout(soTimeout);
			this.datagramSocket.setReuseAddress(reuseAddress);
			this.datagramSocket.setSendBufferSize(sendBufferSize);
			this.datagramSocket.setReceiveBufferSize(receiveBufferSize);
			//3.绑定本地主机的一个IP和端口
			if(null!=localHost && null!=localPort)
				this.datagramSocket.bind(new InetSocketAddress(localHost, localPort));
			//4.设置目标地址
			if(null!=toHost && null!=toPort)
				inetSocketAddress = new InetSocketAddress(toHost, toPort);
			logger.info(MessageFormat.format(SUCCESS, toHost, toPort, localHost, localPort));
			//5.启动数据接收监听线程
			new Thread(new ReceiveListener()).start();
		}
	}
	
	/**
	 * 关闭DatagramSocket
	 * @return true=成功关闭
	 */
	public boolean close(){
		if (inetSocketAddress!=null) {
			inetSocketAddress=null;
		}
		if (datagramSocket!=null) {
			datagramSocket.close();
			datagramSocket=null;
		}
		return true;
	}

	/**
	 * 使用初始化时设置的目标地址<B>广播</B>发送数据报。注意区分广播地址。
	 * @param msg 需要发送的数据
	 * @throws IOException
	 */
	public void sendBroadcast(byte[] msg) throws IOException{
		if(null==this.inetSocketAddress)
			throw new IOException("the target address is null.");
		DatagramPacket sendPacket = new DatagramPacket(msg, msg.length, inetSocketAddress);
		datagramSocket.send(sendPacket);
	}

	/**
	 * 根据参数设置的目标地址<B>广播</B>发送数据报。注意区分广播地址。
	 * @param msg 需要发送的数据
	 * @param toHost 目标地址
	 * @param toPort 目标端口
	 * @throws IOException
	 */
	public void sendBroadcast(byte[] msg, String toHost, int toPort) throws IOException{
		InetAddress inetAddr = InetAddress.getByName(toHost);
		DatagramPacket sendPacket = new DatagramPacket(msg, msg.length, inetAddr, toPort);
		datagramSocket.send(sendPacket);
	}
	
	/**
	 * <p>内部负责监听接收数据的线程类。</p>
	 * @author helizfamily helizfamily@qq.com
	 * @version 1.0 2016年3月31日-上午9:25:23
	 * @modifyed helizfamily helizfamily@qq.com
	 * @purpose Receive监听接收数据的线程类。
	 */
	class ReceiveListener implements Runnable{
		@Override
		public void run() {
			try{
				while(true){
					DatagramPacket datagramPacket = 
							new DatagramPacket(new byte[receiveBufferSize], receiveBufferSize);
					datagramSocket.receive(datagramPacket);
		            DatagramSocketHandle dgst = getDatagramSocketHandle().getClass().newInstance();
		            dgst.setDatagramPacket(datagramPacket);
		            new Thread(dgst).start();
				}
			}catch(Exception e){
				logger.error(MessageFormat.format(ACCEPT, toHost, toPort, localHost, localPort), e);
			}
		}
	}

	/**
	 * @return the datagramSocket
	 */
	public DatagramSocket getDatagramSocket() {
		return datagramSocket;
	}

	/**
	 * @param datagramSocket the datagramSocket to set
	 */
	public void setDatagramSocket(DatagramSocket datagramSocket) {
		this.datagramSocket = datagramSocket;
	}
	
}


package com.eduinline.tools.base.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.text.MessageFormat;

/**
 * <p>com.helizfamily.tools.base.net.DatagramSocketMulticast.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年4月1日-下午2:32:22
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose 基于UDP协议进行多播的Socket套接字客户端。多播组通过 D类IP地址和标准UDP端口号指定。
 * D类IP地址在 224.0.0.0 和 239.255.255.255 的范围内（包括两者）。地址 224.0.0.0 被保留，不应使用。
 */
public class DatagramSocketMulticast extends DatagramSocketAbstract{

	protected boolean loopbackMode = true;

	protected int timeToLive = 0;

	/** 多播客户端 */
	protected MulticastSocket datagramSocket = null;

	/**
	 * 默认构造函数
	 */
	public DatagramSocketMulticast(){
		super();
	}

	/**
	 * 根据目标地址和端口构造客户端
	 * @param toHost 数据报接收地址
	 * @param toPort 数据报接收端口
	 */
	public DatagramSocketMulticast(String toHost, int toPort){
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
	public DatagramSocketMulticast(String toHost, int toPort, String localHost, int localPort){
		this.toHost = toHost;
		this.toPort = toPort;
		this.localHost = localHost;
		this.localPort = localPort;
	}

	/**
	 * 注册客户端
	 */
	public void regist() throws IOException{
		if(this.datagramSocket == null || this.datagramSocket.isClosed()){
			//1.创建对象
			this.datagramSocket = new MulticastSocket(null);
			//2.设置配置参数
			this.datagramSocket.setBroadcast(broadcast);
			this.datagramSocket.setSoTimeout(soTimeout);
			this.datagramSocket.setReuseAddress(reuseAddress);
			this.datagramSocket.setSendBufferSize(sendBufferSize);
			this.datagramSocket.setReceiveBufferSize(receiveBufferSize);
			this.datagramSocket.setLoopbackMode(loopbackMode);
			this.datagramSocket.setTimeToLive(timeToLive);
			//3.绑定本地主机的一个IP和端口
			if(null!=localHost && null!=localPort)
				this.datagramSocket.bind(new InetSocketAddress(localHost, localPort));
			//4.加入多播组
			if(null==toHost || null==toPort)
				throw new IOException("the toHost and toPort is null.");
			InetAddress inetAddress = InetAddress.getByName(toHost);
			this.datagramSocket.joinGroup(inetAddress);
			//5.初始化目标地址
			inetSocketAddress = new InetSocketAddress(inetAddress, toPort);
			logger.info(MessageFormat.format(SUCCESS, toHost, toPort, localHost, localPort));
			//6.启动数据接收监听线程
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
	 * 使用初始化时设置的目标地址<B>多播</B>发送数据报
	 * @param msg 需要发送的数据
	 * @throws IOException
	 */
	public void sendMulticast(byte[] msg) throws IOException{
		if(null==this.inetSocketAddress)
			throw new IOException("the target address is null.");
		DatagramPacket sendPacket = new DatagramPacket(msg, msg.length, inetSocketAddress);
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
	 * @return the loopbackMode
	 */
	public boolean isLoopbackMode() {
		return loopbackMode;
	}

	/**
	 * @param loopbackMode the loopbackMode to set
	 */
	public void setLoopbackMode(boolean loopbackMode) {
		this.loopbackMode = loopbackMode;
	}

	/**
	 * @return the timeToLive
	 */
	public int getTimeToLive() {
		return timeToLive;
	}

	/**
	 * @param timeToLive the timeToLive to set
	 */
	public void setTimeToLive(int timeToLive) {
		this.timeToLive = timeToLive;
	}

	/**
	 * @return the datagramSocket
	 */
	public MulticastSocket getDatagramSocket() {
		return datagramSocket;
	}

	/**
	 * @param datagramSocket the datagramSocket to set
	 */
	public void setDatagramSocket(MulticastSocket datagramSocket) {
		this.datagramSocket = datagramSocket;
	}

}


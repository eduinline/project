package com.eduinline.tools.base.net;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>com.helizfamily.tools.base.net.DatagramSocketClient.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年4月1日-下午2:32:22
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose 基于UDP协议进行单播和广播的Socket套接字公共类。
 */
public abstract class DatagramSocketAbstract extends SocketBase{
	
	protected static final String SUCCESS = 
			"DatagramSocket客户端初始化成功.toHost={0},toPort={1},localIP={2},localPort={3}";
	
	protected static final String CLOSE = 
			"DatagramSocket关闭异常.toHost={0},toPort={1},localIP={2},localPort={3}";
	
	protected static final String ACCEPT = 
			"DatagramSocket读取数据报异常.toHost={0},toPort={1},localIP={2},localPort={3}";
	
	/** 日志对象 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/** DatagramSocket接收数据处理线程 */
	protected DatagramSocketHandle datagramSocketHandle = null;

	/** 发送数据包的目标地址 */
	protected InetSocketAddress inetSocketAddress = null;

	/** 服务端主机 */
	protected String toHost = "127.0.0.1";

	/** 服务端端口 */
	protected Integer toPort = 8899;
	
	/**
	 * 是否开启广播功能，默认开启。
	 */
	protected boolean broadcast = true;

	/**
	 * 在默认情况下，输出流的发送缓冲区是8096个字节(8K)。这个值是Java所建议的输出缓冲区的大小。如果这个
	 * 默认值不能满足要求，可以用setSendBufferSize方法来重新设置缓冲区的大小。但最好不要将输出缓冲区
	 * 设得太小，否则会导致传输数据过于频繁，从而降低网络传输的效率。如果底层的Socket实现不支持
	 * SO_SENDBUF选项，这两个方法将会抛出SocketException例外。必须将size设为正整数，否则
	 * setSendBufferedSize方法将抛出IllegalArgumentException例外。
	 */
	protected int sendBufferSize = 8096;
	
	/**
	 * @return the datagramSocketHandle
	 */
	public DatagramSocketHandle getDatagramSocketHandle() {
		return datagramSocketHandle;
	}

	/**
	 * @param datagramSocketHandle the datagramSocketHandle to set
	 */
	public void setDatagramSocketHandle(DatagramSocketHandle datagramSocketHandle) {
		this.datagramSocketHandle = datagramSocketHandle;
	}

	/**
	 * @return the inetSocketAddress
	 */
	public InetSocketAddress getInetSocketAddress() {
		return inetSocketAddress;
	}

	/**
	 * @param inetSocketAddress the inetSocketAddress to set
	 */
	public void setInetSocketAddress(InetSocketAddress inetSocketAddress) {
		this.inetSocketAddress = inetSocketAddress;
	}

	/**
	 * @return the toHost
	 */
	public String getToHost() {
		return toHost;
	}

	/**
	 * @param toHost the toHost to set
	 */
	public void setToHost(String toHost) {
		this.toHost = toHost;
	}

	/**
	 * @return the toPort
	 */
	public Integer getToPort() {
		return toPort;
	}

	/**
	 * @param toPort the toPort to set
	 */
	public void setToPort(Integer toPort) {
		this.toPort = toPort;
	}

	/**
	 * @return the broadcast
	 */
	public boolean isBroadcast() {
		return broadcast;
	}

	/**
	 * @param broadcast the broadcast to set
	 */
	public void setBroadcast(boolean broadcast) {
		this.broadcast = broadcast;
	}

	/**
	 * @return the sendBufferSize
	 */
	public int getSendBufferSize() {
		return sendBufferSize;
	}

	/**
	 * @param sendBufferSize the sendBufferSize to set
	 */
	public void setSendBufferSize(int sendBufferSize) {
		this.sendBufferSize = sendBufferSize;
	}
	
}


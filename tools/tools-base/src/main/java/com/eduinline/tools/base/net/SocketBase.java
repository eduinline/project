package com.eduinline.tools.base.net;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>com.helizfamily.tools.base.net.SocketParent.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年4月1日-下午4:48:32
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose Socket处理的公共类。
 */
public class SocketBase {
	
	/** 日志对象 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/** 本地主机的IP,方便绑定多网卡主机的IP */
	protected String localHost;

	/** 本地主机的端口，方便绑定多网卡主机的某个端口 */
	protected Integer localPort;
	
	/**
	 * 当TCP连接关闭后其套接字可能会在一段时间内保持超时状态，这个时候如果我们的应用程序想立即使用该套接字
	 * 则会因为其还处在tTIME_OUT状态而失败。通过设置SO_REUSEADDR可以避免这种情况。当创建一个套接字时
	 * SO_REUSEADDR初始设置是禁用的。
	 */
	protected boolean reuseAddress =true;

	/**
	 * 这个Socket选项在前面已经讨论过。可以通过这个选项来设置读取数据超时。当输入流的read方法被阻塞时，
	 * 如果设置timeout(timeout的单位是毫秒)，那么系统在等待了timeout毫秒后会抛出一个
	 * InterruptedIOException例外。在抛出例外后，输入流并未关闭，你可以继续通过read方法读取数据。
	 * 如果将timeout设为0，就意味着read将会无限等待下去，直到服务端程序关闭这个Socket。
	 * 这也是timeout的默认值。这里设置为0s,表示不限时。
	 */
	protected int soTimeout = 0;

	/**
	 * 在默认情况下，输入流的接收缓冲区是8096个字节(8K)。这个值是Java所建议的输入缓冲区的大小。如果这个
	 * 默认值不能满足要求，可以用setReceiveBufferSize方法来重新设置缓冲区的大小。但最好不要将输入缓冲
	 * 区设得太小，否则会导致传输数据过于频繁，从而降低网络传输的效率。如果底层的Socket实现不支持
	 * SO_RCVBUF选项，这两个方法将会抛出SocketException例外。必须将size设为正整数，否则
	 * setReceiveBufferSize方法将抛出IllegalArgumentException例外。
	 */
	protected int receiveBufferSize = 8096;

	/**
	 * @return the reuseAddress
	 */
	public boolean isReuseAddress() {
		return reuseAddress;
	}

	/**
	 * @param reuseAddress the reuseAddress to set
	 */
	public void setReuseAddress(boolean reuseAddress) {
		this.reuseAddress = reuseAddress;
	}

	/**
	 * @return the soTimeout
	 */
	public int getSoTimeout() {
		return soTimeout;
	}

	/**
	 * @param soTimeout the soTimeout to set
	 */
	public void setSoTimeout(int soTimeout) {
		this.soTimeout = soTimeout;
	}

	/**
	 * @return the receiveBufferSize
	 */
	public int getReceiveBufferSize() {
		return receiveBufferSize;
	}

	/**
	 * @param receiveBufferSize the receiveBufferSize to set
	 */
	public void setReceiveBufferSize(int receiveBufferSize) {
		this.receiveBufferSize = receiveBufferSize;
	}

	/**
	 * @return the localHost
	 */
	public String getLocalHost() {
		return localHost;
	}

	/**
	 * @param localHost the localHost to set
	 */
	public void setLocalHost(String localHost) {
		this.localHost = localHost;
	}

	/**
	 * @return the localPort
	 */
	public Integer getLocalPort() {
		return localPort;
	}

	/**
	 * @param localPort the localPort to set
	 */
	public void setLocalPort(Integer localPort) {
		this.localPort = localPort;
	}
	
}


package com.eduinline.tools.net;

import java.net.Socket;

/**
 * <p>com.helizfamily.tools.base.net.TestSocket.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年3月28日-上午9:43:34
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose Socket线程处理类的具体实现。
 */
public class SocketHandleImpl extends SocketHandle {

	/**
	  * 默认构造函数 
	  */
	public SocketHandleImpl() {
		super();
	}
	
	/**
	  * 创建一个新的实例 
	  * @param socket
	  */
	public SocketHandleImpl(Socket socket, boolean keepOnLine) {
		this.socket = socket;
		this.keepOnLine = keepOnLine;
	}

	/*
	  * @param recieveData
	  * @return
	  * @see com.helizfamily.tools.base.net.ServerSocketThread#handle(byte[])
	  */
	@Override
	public byte[] handle(byte[] recieveData) {
		System.out.println("接收："+new String(recieveData));
		byte[] data = "hello, girl!".getBytes();
		return data;
	}

}


package com.eduinline.tools.base.net;

import java.net.DatagramPacket;

/**
 * <p>com.helizfamily.tools.base.net.DatagramSocketHandleImpl.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年4月6日-下午4:09:43
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose DatagramSocket处理接收的消息具体实现类。
 */
public class DatagramSocketHandleImpl extends DatagramSocketHandle {

	/*
	 * @param datagramPacket
	 * @see com.helizfamily.tools.base.net.DatagramSocketHandle#handle(java.net.DatagramPacket)
	 */
	@Override
	public void handle(DatagramPacket datagramPacket) {
		System.out.println(new String(datagramPacket.getData()));
	}

}


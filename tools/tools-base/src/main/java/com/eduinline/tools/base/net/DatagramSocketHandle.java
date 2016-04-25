package com.eduinline.tools.base.net;

import java.net.DatagramPacket;

/**
 * <p>com.helizfamily.tools.base.net.DatagramSocketThread.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年4月6日-上午10:54:48
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose DatagramSocket接收信息抽象处理线程类，方便子类继续处理。
 */
public abstract class DatagramSocketHandle implements Runnable {
	
	/** 接收的数据报 */
	protected DatagramPacket datagramPacket;
	
	/**
	 * 抽象方法，子类实现。根据DatagramSocket得到的数据报进行处理
	 * @param datagramPacket DatagramSocket读取的数据
	 */
	public abstract void handle(DatagramPacket datagramPacket);

	/*
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		handle(datagramPacket);
	}

	/**
	 * @return the datagramPacket
	 */
	public DatagramPacket getDatagramPacket() {
		return datagramPacket;
	}

	/**
	 * @param datagramPacket the datagramPacket to set
	 */
	public void setDatagramPacket(DatagramPacket datagramPacket) {
		this.datagramPacket = datagramPacket;
	}
	
}


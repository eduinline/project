/* ***********************************************************************
 * Copyright (C) 1992-2016 中国南方航空股份有限公司.
 *
 * Created [2016年4月28日 下午12:51:05] by FMS Team
 * ***********************************************************************
 *
 * tools-base
 * ***********************************************************************
 */
package com.eduinline.tools.base.io;

/**
 * <p>接收管道数据后进行处理的处理器</p>
 *
 * @author hongze.he@eduinline.com
 * @version 1.0 2016年4月26日-下午9:41:39
 */
public abstract class PipedReceiveHandle implements Runnable {

	private Object receiveData;
	
	/**
	 * 处理字节数据的方法。
	 * @param receiveData
	 */
	public abstract void handleByte(byte[] receiveData);
	
	/**
	 * 处理字符数据的方法。
	 * @param receiveData
	 */
	public abstract void handleChar(char[] receiveData);
	
	/*
	  * @see java.lang.Runnable#run()
	  */
	@Override
	public void run() {
		if(receiveData instanceof byte[]){
			byte[] data = (byte[]) receiveData;
			handleByte(data);
		}else if(receiveData instanceof char[]){
			char[] data = (char[]) receiveData;
			handleChar(data);
		}
	}

	/**
	 * @return the receiveData
	 */
	public Object getReceiveData() {
		return receiveData;
	}

	/**
	 * @param receiveData the receiveData to set
	 */
	public void setReceiveData(Object receiveData) {
		this.receiveData = receiveData;
	}
	
}


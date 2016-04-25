package com.eduinline.tools.base.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * <p>com.helizfamily.tools.base.rmi.RmiServerInterface.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年3月8日-上午9:57:13
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose RMI服务端定义的接口，必须继承Remote，方法抛出RemoteException，方便客户端处理
 */
public interface RmiServer extends Remote {
	
	/**
	 * 根据名称处理业务
	 * @param name 业务名称
	 * @return 处理成功返回True,否则失败
	 * @throws RemoteException
	 */
	boolean doBusiness(String name) throws RemoteException;
	
}


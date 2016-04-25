package com.eduinline.tools.base.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * <p>com.helizfamily.tools.base.rmi.RmiServerImpl.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年3月8日-上午10:06:07
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose Rmi接口实现类，处理具体的业务。需实现UnicastRemoteObject
 */
public class RmiServerImpl extends UnicastRemoteObject implements RmiServer {

	private static final long serialVersionUID = 1L;
	
	protected RmiServerImpl() throws RemoteException {
		super();
	}

	/*
	  * @param name
	  * @return
	  * @throws RemoteException
	  * @see com.helizfamily.tools.base.rmi.RmiServer#doBusiness(java.lang.String)
	  */
	@Override
	public boolean doBusiness(String name) throws RemoteException {
		System.out.println(name);
		return false;
	}

}


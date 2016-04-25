package com.eduinline.tools.base.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * <p>com.helizfamily.tools.base.rmi.RmiClient.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年3月8日-上午10:29:06
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose Rmi客户端调用
 */
public class RmiClient {
	
	public static void main(String[] args) {
		String url = "rmi://localhost:1099/RmiServerImpl";
		boolean result = false;
		try {
			RmiServer helloService = (RmiServer) Naming.lookup(url);
			result = helloService.doBusiness("you");
		} catch (MalformedURLException e1) {
			System.out.println("URL格式错误异常");
		} catch (RemoteException e1) {
			System.out.println("服务连接异常");
		} catch (NotBoundException e1) {
			System.out.println("服务未注册异常");
		}
        System.out.println(result);
	}

}


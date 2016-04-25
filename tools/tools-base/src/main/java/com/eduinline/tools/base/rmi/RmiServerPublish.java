package com.eduinline.tools.base.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * <p>com.helizfamily.tools.base.rmi.RmiServerPublish.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年3月8日-上午10:16:08
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose 发布RMI服务,数据是基于 TCP/IP协议传送<br>
 * 在服务端我们发布了 RMI 服务，并在 JNDI 中进行了注册，此时就在服务端创建了一个 Skeleton（骨架），<br>
 * 当客户端第一次成功连接 JNDI 并获取远程服务对象后，立马就在本地创建了一个 Stub（存根），<br>
 * 远程通信实际上是通过 Skeleton 与 Stub 来完成的，数据是基于 TCP/IP 协议，在“传输层”上发送。<br>
 * 缺点：不能实现跨语言系统之间的调用，只局限于Java系统之间的交互。
 */
public class RmiServerPublish {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		//http://www.open-open.com/lib/view/open1416097626352.html
		int port = 1099;
		String url = "rmi://localhost:1099/RmiServerImpl";
		LocateRegistry.createRegistry(port);
		Naming.rebind(url, new RmiServerImpl());
	}

}


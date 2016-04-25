package com.eduinline.tools.base.net;

import java.io.IOException;

/**
* <p>com.helizfamily.tools.base.net.SocketThread.java</p>
*
* @author helizfamily helizfamily@qq.com
* @version 1.0 2016年3月31日-下午6:08:03
* @modifyed helizfamily helizfamily@qq.com
* @purpose Socket访问处理线程类。
*/
public abstract class SocketHandle extends SocketAbstract implements Runnable {

	/**
	 * 抽象方法，子类实现。根据Socket得到的数据进行处理
	 * @param recieveData Socket读取的数据
	 * @return 返回给客户端的数据
	 */
	public abstract byte[] handle(byte[] recieveData);
	
	@Override
	public void run() {
		try{
			if(keepOnLine){
				while(keepOnLine){
					handleAccept();
				}
			}else{
				handleAccept();
			}
		}catch(IOException e){
			logger.error("Socket处理异常", e);
		}finally {
			try {
				socket.close();
			} catch (IOException e) {
				logger.error("关闭Socket异常", e);
			}
		}
	}
	
	/**
	 * 处理Accept后的消息并返回
	 * @throws IOException
	 */
	private void handleAccept() throws IOException{
		byte[] receiveData = receiveData();
		if(null!=receiveData){
			byte[] sendData = handle(receiveData);
			if(null!=sendData)
				sendData(sendData);
		}
	}
	
}

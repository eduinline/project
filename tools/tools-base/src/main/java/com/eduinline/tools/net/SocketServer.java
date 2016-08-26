package com.eduinline.tools.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.MessageFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>com.helizfamily.tools.base.net.SocketUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年3月18日-下午6:41:36
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose Socket服务端。
 */
public class SocketServer extends SocketBase{

	/** 日志记录器 */
	private static final Logger logger = 
			LoggerFactory.getLogger(SocketServer.class);

	private static final String SUCCESS = "Socket服务器成功启动.IP={0},Port={1}";

	private static final String ACCEPT = "Socket服务器监听异常.IP={0},Port={1}";

	private static final String CLOSE = "Socket服务器关闭异常.IP={0},Port={1}";

	/** 连接队列里最大连接数 */
	private int backlog = 50;

	/** 是否保持在线状态 */
	private boolean keepOnLine = true;

	/** ServerSocket */
	private ServerSocket serverSocket;
	
	/** Accept后处理业务的线程对象 */
	private SocketHandle socketHandle;

	/** 线程池，用于在接收到客户端访问后，触发处理线程 */
	private ExecutorService executorService;

	/**
	 * 构造函数。
	 * @param localPort ServerSocket使用的端口
	 */
	public SocketServer(int localPort){
		this.localPort = localPort;
	}

	/**
	 * 构造函数。
	 * @param port ServerSocket使用的端口
	 * @param backlog ServerSocket最大连接数
	 */
	public SocketServer(int localPort, int backlog){
		this.localPort = localPort;
		this.backlog = backlog;
	}

	/**
	 * 构造函数。
	 * @param port ServerSocket使用的端口
	 * @param backlog ServerSocket最大连接数
	 */
	public SocketServer(String localHost, int localPort, int backlog){
		this.localHost = localHost;
		this.localPort = localPort;
		this.backlog = backlog;
	}

	/**
	 * 注册Socket服务端
	 * @return true=注册成功
	 * @throws IOException 
	 */
	public void regist() throws IOException{
		if(this.serverSocket==null || this.serverSocket.isClosed()){
			//1.创建对象
			this.serverSocket = new ServerSocket();
			//2.设置配置参数
			this.serverSocket.setReuseAddress(reuseAddress);
			//this.serverSocket.setSoTimeout(soTimeout);
			this.serverSocket.setReceiveBufferSize(receiveBufferSize);
			//3.绑定本地主机的一个IP和端口
			if(null!=localHost && null!=localHost)
				this.serverSocket.bind(new InetSocketAddress(localHost, localPort), backlog);
			else
				this.serverSocket.bind(new InetSocketAddress(localPort), backlog);
			//4.启动监听线程
			this.executorService = Executors.newCachedThreadPool();
			executorService.execute(new AcceptListener());
		}
		logger.info(MessageFormat.format(SUCCESS, localHost, localPort));
	}

	/**
	 * 关闭ServerSocket连接
	 * @return true=成功关闭
	 * @throws IOException 
	 */
	public boolean close(){
		try{
			if (serverSocket!=null) {
				serverSocket.close();
				serverSocket=null;
			}
			return true;
		}catch(IOException e){
			logger.error(MessageFormat.format(CLOSE, localHost, localPort));
			return false;
		}
	}

	/**
	 * <p>内部负责监听的线程类，负责监听客户端的访问处理。</p>
	 * @author helizfamily helizfamily@qq.com
	 * @version 1.0 2016年3月31日-上午9:25:23
	 * @modifyed helizfamily helizfamily@qq.com
	 * @purpose Accept监听内部线程类。
	 */
	class AcceptListener implements Runnable{
		@Override
		public void run() {
			try{
				while(true){
					Socket socket =  serverSocket.accept();
					SocketHandle st = getSocketHandle().getClass().newInstance();
					st.setSocket(socket);
					st.setKeepOnLine(keepOnLine);
					executorService.execute(st);
				}
			}catch(Exception e){
				logger.error(MessageFormat.format(ACCEPT, localHost, localPort), e);
				close();
			}
		}
	}

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
	 * @return the backlog
	 */
	public int getBacklog() {
		return backlog;
	}

	/**
	 * @param backlog the backlog to set
	 */
	public void setBacklog(int backlog) {
		this.backlog = backlog;
	}

	/**
	 * @return the keepOnLine
	 */
	public boolean isKeepOnLine() {
		return keepOnLine;
	}

	/**
	 * @param keepOnLine the keepOnLine to set
	 */
	public void setKeepOnLine(boolean keepOnLine) {
		this.keepOnLine = keepOnLine;
	}
	
	/**
	 * @return the socketHandle
	 */
	public SocketHandle getSocketHandle() {
		return socketHandle;
	}

	/**
	 * @param socketHandle the socketHandle to set
	 */
	public void setSocketHandle(SocketHandle socketHandle) {
		this.socketHandle = socketHandle;
	}

	public static void main(String[] args) throws IOException {
		SocketServer ss = new SocketServer(8899);
		ss.setSocketHandle(new SocketHandleImpl());
		ss.regist();
	}
	
}


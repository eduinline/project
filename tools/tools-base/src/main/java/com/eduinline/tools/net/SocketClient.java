package com.eduinline.tools.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * <p>com.helizfamily.tools.base.net.SocketUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年3月18日-下午6:41:36
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose Socket客户端。
 */
public class SocketClient extends SocketAbs{

	private static final String SUCCESS = 
			"Socket客户端连接成功.serverIP={0},serverPort={1},localIP={2},localPort={3}";

	/** 服务端主机 */
	private String serverHost = "127.0.0.1";

	/** 服务端端口 */
	private int serverPort = 8899;

	/** 连接服务器时超时20s没有连接成功则连接超时 */
	private int connectTimeout = 20000;

	/**
	 * 如果将这个Socket选项打开，客户端Socket每隔段的时间（大约两个小时）就会利用空闲的连接向服务器发送
	 * 一个数据包。这个数据包并没有其它的作用，只是为了检测一下服务器是否仍处于活动状态。如果服务器未响应这
	 * 个数据包，在大约11分钟后，客户端Socket再发送一个数据包，如果在12分钟内，服务器还没响应，那么客户端
	 * Socket将关闭。如果将Socket选项关闭，客户端Socket在服务器无效的情况下可能会长时间不会关闭。
	 * SO_KEEPALIVE选项在默认情况下是关闭的。
	 */
	private boolean keepAlive =true;

	/**
	 * 在默认情况下,这个选项是禁用的，并且在TCP套接字上接收单字节紧急数据会被默认丢弃。如果用户希望接收单字
	 * 节紧急数据,那么必须启用这个选项。启用时,单字节紧急数据接收会与正常数据组合在一起。注意,只提供了有限的
	 * 支持来处理传入的紧急数据。特别需要指出的是,除非通过更高级别的协议，否则无法完全正确地区分识别正常数据
	 * 和紧急数据。
	 */
	private boolean OOBInline =true;

	/**
	 * 这个Socket选项可以影响close方法的行为。在默认情况下，当调用close方法后，将立即执行；如果这时仍然
	 * 有未被送出的数据包，那么这些数据包将被丢弃。如果将linger参数设为一个正整数n时(n的值最大是65535)，
	 * 在调用close方法后，将最多被阻塞n秒。在这n秒内，系统将尽量将未送出的数据包发送出去；如果超过了n秒，
	 * 还有未发送的数据包，这些数据包将全部被丢弃；而close方法会立即返回。返回-1，则表明SO_LINGER是关闭的.
	 * 第二个参数单位是秒。
	 */
	private boolean soLinger =true;

	/** soLinger的延迟关闭时间，单位是秒 */
	private int linger = 10;

	/**
	 * 在默认情况下，客户端向服务器发送数据时，会根据数据包的大小决定是否立即发送。当数据包中的数据很少时，
	 * 如只有1个字节，而数据包的头却有几十个字节（IP头+TCP头）时，系统会在发送之前先将较小的包合并到较大
	 * 的包后，一起将数据发送出去。在发送下一个数据包时，系统会等待服务器对前一个数据包的响应，当收到服务器
	 * 的响应后，再发送下一个数据包，这就是所谓的Nagle算法。在默认情况下，Nagle算法是开启的。这种算法虽
	 * 然可以有效地改善网络传输的效率，但对于网络速度比较慢，而且对实现性的要求比较高的情况下（如游戏、
	 * Telnet等），使用这种方式传输数据会使得客户端有明显的停顿现象。因此，最好的解决方案就是需要Nagle算法
	 * 时就使用它，不需要时就关闭它。而使用setTcpToDelay正好可以满足这个需求。当使用setTcpNoDelay(true)
	 * 将Nagle算法关闭后，客户端每发送一次数据，无论数据包的大小都会将这些数据发送出去。
	 */
	private boolean tcpNoDelay = true;

	/**
	 * 在默认情况下，输出流的发送缓冲区是8096个字节(8K)。这个值是Java所建议的输出缓冲区的大小。如果这个
	 * 默认值不能满足要求，可以用setSendBufferSize方法来重新设置缓冲区的大小。但最好不要将输出缓冲区
	 * 设得太小，否则会导致传输数据过于频繁，从而降低网络传输的效率。如果底层的Socket实现不支持
	 * SO_SENDBUF选项，这两个方法将会抛出SocketException例外。必须将size设为正整数，否则
	 * setSendBufferedSize方法将抛出IllegalArgumentException例外。
	 */
	private int sendBufferSize = 8096;

	/**
	 * 构造函数
	 * @param serverHost 服务器的IP
	 * @param serverPort 服务器的端口
	 */
	public SocketClient(String serverHost, int serverPort){
		this.serverHost = serverHost;
		this.serverPort = serverPort;
	}

	/**
	 * 构造函数
	 * @param serverHost 服务器的IP
	 * @param serverPort 服务器的端口
	 * @param localHost 绑定本地主机IP
	 * @param localPort 绑定本地主机端口
	 */
	public SocketClient(String serverHost, int serverPort, String localHost, int localPort){
		this.serverHost = serverHost;
		this.serverPort = serverPort;
		this.localHost = localHost;
		this.localPort = localPort;
	}

	/**
	 * 注册Socket客户端
	 * @return true=注册成功
	 */
	public void regist() throws IOException{
		if(this.socket == null || this.socket.isClosed() || !this.socket.isConnected()){
			//1.创建对象
			this.socket = new Socket();
			//2.设置配置参数
			this.socket.setKeepAlive(keepAlive);
			this.socket.setOOBInline(OOBInline);
			this.socket.setReuseAddress(reuseAddress);
			this.socket.setSoLinger(soLinger, linger);
			this.socket.setSoTimeout(soTimeout);
			this.socket.setTcpNoDelay(tcpNoDelay);
			this.socket.setSendBufferSize(sendBufferSize);
			this.socket.setReceiveBufferSize(receiveBufferSize);
			//socket.setPerformancePreferences(connectionTime, latency, bandwidth);
			//3.绑定本地主机的一个IP和端口
			if(null!=localHost && null!=localPort)
				this.socket.bind(new InetSocketAddress(localHost, localPort));
			//4.连接远程服务器的IP和端口，并设置超时时间毫秒数：20s
			this.socket.connect(new InetSocketAddress(serverHost, serverPort), connectTimeout);
			//5.获取输入输出流
			this.in = this.socket.getInputStream();
			this.out = this.socket.getOutputStream();
			logger.info(logMessage(SUCCESS));
		}
	}
	
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		SocketClient r = new SocketClient("127.0.0.1", 8899);
		r.regist();
		for(int i=0; i<100; i++){
			r.sendData((i+"你妹子的！").getBytes());
			byte[] data = r.receiveData();
			System.out.println("返回："+new String(data));
			Thread.currentThread();
			Thread.sleep(1000);
		}
		r.close();
	}
	
}


package com.eduinline.tools.base.nio;

/**
 * <p>com.helizfamily.tools.base.nio.DatagramChannelUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年3月9日-下午4:34:15
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose NIO数据报通道工具类。因为UDP是无连接的网络协议，所以不能像其它通道那样读取和写入。它发送和接收的是数据包。
 * 流程：Channel-->Buffer-->Channel
 * 特点1Channels and Buffers：标准的IO基于字节流和字符流进行操作的，而NIO是基于通道（Channel）和缓冲区（Buffer）进行操作，
 * 数据总是从通道读取到缓冲区中，或者从缓冲区写入到通道中。<br>
 * 
 * 特点2Non-blocking IO：NIO可以让你非阻塞的使用IO，例如：当线程从通道读取数据到缓冲区时，线程还是可以进行其他事情。
 * 当数据被写入到缓冲区时，线程可以继续处理它。从缓冲区写入通道也类似。
 * 
 * 特点3Selectors：NIO引入了选择器的概念，选择器用于监听多个通道的事件（比如：连接打开，数据到达）。因此，单个的线程可以监听多个数据通道。
 */
public class DatagramChannelUtil {

}


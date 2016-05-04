package com.eduinline.tools.base.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>NIO文件通道工具类。不能将FileChannel与Selector一起使用，因为FileChannel不能切换到非阻塞模式</p>
 * <ul>
 * 	<li>流程：Channel-->Buffer-->Channel</li>
 * 	<li>特点1Channels and Buffers：标准的IO基于字节流和字符流进行操作的，而NIO是基于通道（Channel）和缓冲区（Buffer）进行操作，
 * 		数据总是从通道读取到缓冲区中，或者从缓冲区写入到通道中。</li>
 * 
 * 	<li>特点2Non-blocking IO：NIO可以让你非阻塞的使用IO，例如：当线程从通道读取数据到缓冲区时，线程还是可以进行其他事情。
 * 		当数据被写入到缓冲区时，线程可以继续处理它。从缓冲区写入通道也类似。</li>
 * 
 * 	<li>特点3Selectors：NIO引入了选择器的概念，选择器用于监听多个通道的事件（比如：连接打开，数据到达）。因此，单个的线程可以监听多个数据通道。</li>
 * </ul>
 * @author hongze.he@eduinline.com
 * @version 1.0 2016年4月26日-下午9:41:39
 */
public class FileChannelUtil {
	
	/**
	 * 根据指定内容创建文件
	 * @param file 需要填充内容的文件对象
	 * @param content 文件内容
	 * @return 文件内容长度
	 * @throws IOException
	 */
	public static long createFile(File file, String content) throws IOException{
		FileOutputStream os = null;
		FileChannel outChannel = null;
		ByteBuffer buf = null;
		try{
			byte[] c = content.getBytes();
			buf = ByteBuffer.wrap(c);
			os = new FileOutputStream(file);
			outChannel = os.getChannel();
			outChannel.write(buf);
			outChannel.force(true);
			return file.length();
		}finally{
			if(null!=os)
				os.close();
			if(null!=outChannel)
				outChannel.close();
			if(null!=buf)
				buf.clear();
		}
	}
	
	/**
	 * 获取文件的内容
	 * @param file 文件对象
	 * @return 文件内容
	 * @throws IOException
	 */
	public static String getFileContent(File file) throws IOException{
		FileInputStream is = null;
		FileChannel inChannel = null;
		ByteBuffer buf = null;
		try{
			is = new FileInputStream(file);
			inChannel = is.getChannel();
			buf = ByteBuffer.allocate((int) inChannel.size());
			inChannel.read(buf);
			return new String(buf.array());
		}finally{
			if(null!=is)
				is.close();
			if(null!=inChannel)
				inChannel.close();
			if(null!=buf)
				buf.clear();
		}
	}
	
	/**
	 * 复制文件
	 * @param src 源文件
	 * @param des 目标文件
	 * @return 成功返回True
	 * @throws IOException
	 */
	public static boolean copyFile(File src, File des) throws IOException{
		FileInputStream is = null;
		FileChannel inChannel = null;
		
		FileOutputStream os = null;
		FileChannel outChannel = null;
		ByteBuffer buf = null;
		
		try{
			is = new FileInputStream(src);
			inChannel = is.getChannel();
			
			os = new FileOutputStream(des);
			outChannel = os.getChannel();
			
			long position = 0;
			long count = inChannel.size();
			inChannel.transferTo(position, count, outChannel);
			return true;
		}finally{
			if(null!=is)
				is.close();
			if(null!=inChannel)
				inChannel.close();
			if(null!=os)
				os.close();
			if(null!=outChannel)
				outChannel.close();
			if(null!=buf)
				buf.clear();
		}
	}
	
}


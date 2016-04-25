package com.eduinline.tools.base.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <p>com.helizfamily.tools.base.io.IOUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年3月9日-上午11:11:14
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose IO处理工具类。IO主要针对流进行操作，主要有字节流(InputStream, OutputStream)和字符流(Reader和Writer)。<br>
 * InputStream子类有：ByteArrayInputStream, FileInputStream, ObjectInputStream, PipedInputStream <br>
 * OutputStream子类有：ByteArrayOutputStream, FileOutputStream, ObjectOutputStream, PipedOutputStream <br>
 * Reader子类有：BufferedReader, InputStreamReader, PipedReader, StringReader <br>
 * Writer子类有：BufferedWriter, OutputStreamWriter, PipedWriter, StringWriter <br>
 * 特别需要注意的是，字节流和字符流之间进行转换的桥梁是：InputStreamReader和OutputStreamWriter <br>
 * InputStreamReader子类有：FileReader <br>
 * OutputStreamWriter子类有：FileWriter <br>
 */
public class IOUtil {
	
	/**
	 * 根据指定内容创建文件
	 * @param file 需要填充内容的文件对象
	 * @param content 文件内容
	 * @return 文件内容长度
	 * @throws IOException
	 */
	public static long createFile(File file, String content) throws IOException{
		FileWriter fw = new FileWriter(file);
		fw.write(content);
		fw.flush();
		fw.close();
		return file.length();
	}
	
	/**
	 * 获取文件的内容
	 * @param file 文件对象
	 * @return 文件内容
	 * @throws IOException
	 */
	public static String getFileContent(File file) throws IOException{
		StringBuilder content = new StringBuilder();
		FileReader fr =new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while ((line=br.readLine())!=null) {
			content.append(line);
		};
		br.close();
		fr.close();
		return content.toString();
	}
	
	/**
	 * 复制文件
	 * @param src 源文件
	 * @param des 目标文件
	 * @return 成功返回True
	 * @throws IOException
	 */
	public static boolean copyFile(File src, File des) throws IOException{
		FileReader fr = new FileReader(src);
		BufferedReader br = new BufferedReader(fr);
		
		FileWriter fw = new FileWriter(des);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String line = null;
		while ((line=br.readLine())!=null) {
			if(line.length()==0)
				bw.write(System.lineSeparator());
			else
				bw.write(line);
		};
		br.close();
		bw.close();
		return true;
	}
	
}


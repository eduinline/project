package com.eduinline.tools.base.io;

import java.io.File;

/**
 * <p>com.helizfamily.tools.base.io.FileUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年3月10日-下午3:44:05
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose IO文件处理工具类。IO针对文件的处理有针对流和字符2种方式。<br>
 * 流式处理的类有：FileInputStream、FileOutputStream、RandomAccessFile
 * 字符式处理的类有：FileReader和FileWriter
 */
public class IOFileUtil {
	
	/**
	 * 列出可用的文件系统根。比如Window系统的C、D、E、F、G盘。<br>
	 * "绝对路径："+file.getAbsolutePath()=C:\ <br>
	 * "总容量："+file.getTotalSpace()得到容量的字节数 <br>
	 * "空闲容量："+file.getFreeSpace()得到容量的字节数 <br>
	 * "可用容量："+file.getFreeSpace()得到容量的字节数 <br>
	 * "已用容量："+(file.getTotalSpace()-file.getFreeSpace())得到容量的字节数 <br>
	 * @return 文件系统根数组
	 */
	public static File[] getRootsFile(){
		return File.listRoots();
	}
	
	
}


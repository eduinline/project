package com.eduinline.tools.base.io;

import java.io.File;
import java.io.IOException;

/**
 * <p>com.helizfamily.tools.base.io.FileUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年3月10日-下午3:44:05
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose IO中针对文件处理工具类。IO针对文件的处理有针对二进制文件和字符文件2种方式。<br>
 * 二进制文件处理的类有：FileInputStream、FileOutputStream、RandomAccessFile
 * 字符文件处理的类有：FileReader和FileWriter
 */
public class FileUtil {
	
	/** 默认文件名称分隔符,window下是'\' */
	public static final String FILE_SEPARATOR = File.separator;
	
	/** 默认名称路径分隔符,window下是';' */
	public static final String FILE_PATH_SEPARATOR = File.pathSeparator;
	
	public static void main(String[] args) {
		System.out.println(new File("E:\\Hehz\\1.开发环境").listFiles().length);
	}
	
	/**
	 * 列出当前系统可用的文件盘。比如Window系统的C、D、E、F、G盘。<p>
	 * "绝对路径："+file.getAbsolutePath()=C:\ <p>
	 * "总容量："+file.getTotalSpace()得到容量的字节数 <p>
	 * "空闲容量："+file.getFreeSpace()得到容量的字节数 <p>
	 * "可用容量："+file.getFreeSpace()得到容量的字节数 <p>
	 * "已用容量："+(file.getTotalSpace()-file.getFreeSpace())得到容量的字节数 <p>
	 * @return 文件系统根数组
	 */
	public static File[] getRootsFile(){
		return File.listRoots();
	}
	
	public static FileDto fileToDto(File file, boolean includeChild){
		if(includeChild){
			FileDto baseDto = toDto(file);
			return toDto(file, baseDto);
		}
		return toDto(file);
	}
	
	/**
	 * 把File对象转换成FileDto对象，重点在转换子目录和文件
	 * @param file 文件对象
	 * @return FileDto
	 */
	private static FileDto toDto(File file, FileDto baseDto){
		File[] files = file.listFiles();
		for (File currentFile : files) {
			FileDto currentDto = toDto(currentFile);
			baseDto.getChildren().add(currentDto);
			if(currentFile.isDirectory()){
				toDto(currentFile, currentDto);
			}
		}
		return baseDto;
	}
	
	/**
	 * 把File对象转换成FileDto对象，不转换子目录和文件
	 * @param file 文件对象
	 * @return FileDto
	 */
	private static FileDto toDto(File file){
		FileDto fileDto  = new FileDto();
		fileDto.setCanRead(file.canRead());
		fileDto.setCanWrite(file.canWrite());
		fileDto.setAbsolutePath(file.getAbsolutePath());
		fileDto.setTotalSpace(file.getTotalSpace());
		fileDto.setFreeSpace(file.getFreeSpace());
		fileDto.setParent(file.getParent());
		fileDto.setDirectory(file.isDirectory());
		fileDto.setFile(file.isFile());
		fileDto.setHidden(file.isHidden());
		return fileDto;
	}
	
	/**
	 * 读文件之前，判断其是否存在和可读
	 * @param file 文件对象
	 * @return true=可读
	 * @throws IOException
	 */
	private boolean checkFileBeforeRead(File file) throws IOException{
		if(!file.exists())
			throw new IOException("文件不存在："+file.getName());
		if(!file.canRead())
			throw new IOException("文件不可读："+file.getName());
		return true;
	}
	
}


package com.eduinline.tools.base.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>IO中针对文件处理工具类。IO针对文件的处理有针对二进制文件和字符文件2种方式。</p>
 * <ul>
 * 	<li>二进制文件处理的类有：FileInputStream、FileOutputStream、RandomAccessFile</li>
 * 	<li>字符文件处理的类有：FileReader和FileWriter</li>
 * </ul>
 *
 * @author hongze.he@eduinline.com
 * @version 1.0 2016年4月26日-下午9:41:39
 */
public class FileUtil {
	/** 日志对象 */
	private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

	/** 默认文件名称分隔符,window下是'\' */
	public static final String FILE_SEPARATOR = File.separator;

	/** 默认名称路径分隔符,window下是';' */
	public static final String FILE_PATH_SEPARATOR = File.pathSeparator;

	/**
	 * 列出当前系统可用的文件盘。比如Window系统的C、D、E、F、G盘。<p>
	 * @return 文件系统根数组
	 */
	public static FileDto[] getRootsFile(){
		File[] files = File.listRoots();
		FileDto[] fileDtos = new FileDto[files.length];
		int i=0;
		for (File file : files) {
			FileDto fileDto = toDto(file);
			fileDtos[i] = fileDto;
			i++;
		}
		return fileDtos;
	}

	/**
	 * 将文件对象转为FileDto对象
	 * @param file 文件对象
	 * @param includeChild 是否转换子文件和目录
	 * @param filterRegex 需要过滤的文件名正则，在includeChild=true下有效，设置为null或空则不进行过滤
	 * @return 转换后得到的FileDto
	 */
	public static FileDto fileToDto(File file, boolean includeChild, final String filterRegex){
		if(includeChild){
			FileDto baseDto = toDto(file);
			FilenameFilter filter = null;
			if(null!=filterRegex && !"".equals(filterRegex)){
				filter = new FilenameFilter() {
					Pattern pattern = Pattern.compile(filterRegex);
					@Override
					public boolean accept(File dir, String name) {
						return pattern.matcher(name).matches();
					}
				};
			}
			return toDto(file, baseDto, filter);
		}
		return toDto(file);
	}

	/**
	 * 根据指定内容创建文件，如果文件存在再覆盖旧文件
	 * @param file 需要填充内容的文件对象
	 * @param content 文件内容
	 * @return true=创建成功
	 */
	public static boolean createFile(File file, String content){
		FileWriter fw = null;
		try{
			if(!file.getParentFile().exists())
				file.getParentFile().mkdirs();
			fw = new FileWriter(file);
			fw.write(content);
			fw.flush();
			return true;
		}catch(IOException e){
			logger.error("创建文件异常："+file.getName(), e);
			return false;
		}finally{
			if(null!=fw)
				try {
					fw.close();
				} catch (IOException e) {
					logger.error("FileWriter异常：", e);
				}
		}
	}

	/**
	 * 添加指定内容到指定File对象。如果File对象已经存在，则追加到文件末尾,否则先创建File
	 * @param file 需要填充内容的文件对象
	 * @param content 文件内容
	 * @return true=创建成功
	 */
	@SuppressWarnings("resource")
	public static boolean appendToFile(File file, String content){
		if(file.exists()){
			RandomAccessFile raFile = null;
			try{
				raFile = new RandomAccessFile(file, "rws");
				raFile.seek(raFile.length());
				raFile.writeChars(System.lineSeparator());
				raFile.writeChars(content);
				return true;
			}catch(IOException e){
				logger.error("追加文件内容异常："+file.getName(), e);
				try{
					if(null!=raFile)
						raFile.close();
				}catch(IOException ex){
					logger.error("关闭随机读写文件异常："+file.getName(), e);
				}
				return false;
			}
		}else{
			createFile(file, content);
			return true;
		}
	}

	/**
	 * 获取指定文件的内容
	 * @param file 文件对象
	 * @return 文件内容
	 */
	public static String getFileContent(File file){
		FileReader fr = null;
		BufferedReader br = null;
		StringBuilder content = new StringBuilder();
		try{
			fr =new FileReader(file);
			br = new BufferedReader(fr);
			String line = null;
			while ((line=br.readLine())!=null) {
				content.append(line);
			};
		}catch(IOException e){
			logger.error("获取文件内容异常："+file.getName(), e);
			return "";
		}finally{
			try{
				if(null!=br)
					br.close();
				if(null!=fr)
					fr.close();
			}catch(IOException e){
				logger.error("关闭文件读写流异常", e);
			}
		}
		return content.toString();
	}

	/**
	 * 复制文件
	 * @param src 源文件
	 * @param des 目标文件
	 * @return 成功返回True
	 * @throws IOException
	 */
	public static boolean copyFile(File src, File des){
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		try{
			fr = new FileReader(src);
			br = new BufferedReader(fr);
			fw = new FileWriter(des);
			bw = new BufferedWriter(fw);
			String line = null;
			while ((line=br.readLine())!=null) {
				if(line.length()==0)
					bw.newLine();
				else
					bw.write(line);
			};
		}catch(IOException e){
			logger.error("复制文件异常：src="+src.getName()+";des="+des.getName(), e);
			return false;
		}finally{
			try{
				if(null!=bw)
					bw.close();
				if(null!=fw)
					fw.close();
				if(null!=br)
					br.close();
				if(null!=fr)
					fr.close();
			}catch(IOException e){
				logger.error("关闭文件读写流异常", e);
			}
		}
		return true;
	}

	/**
	 * 把File对象转换成FileDto对象，转换子目录和文件
	 * @param file 文件对象
	 * @return FileDto
	 */
	private static FileDto toDto(File file, FileDto baseDto, FilenameFilter filenameFilter){
		File[] files = null;
		if(null!=filenameFilter)
			files = file.listFiles(filenameFilter);
		else	
			files = file.listFiles();
		for (File currentFile : files) {
			FileDto currentDto = toDto(currentFile);
			baseDto.getChildren().add(currentDto);
			if(currentFile.isDirectory()){
				toDto(currentFile, currentDto, filenameFilter);
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

}


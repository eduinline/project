package com.eduinline.tools.base.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * <p>com.helizfamily.tools.base.util.ZipUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年2月19日-下午4:50:45
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose 字符串和文件的压缩、解压缩处理
 */
public class ZipUtil {

	/**
	 * gzip(使用Gzip压缩字符串)
	 * @param src 需要压缩的字符串
	 * @return 压缩后的字符串
	 * @throws IOException
	 */
	public static String gzip(String src) throws IOException {
		byte[] srcByte = src.getBytes();
		return gzip(srcByte);
	}

	/**
	 * gzip(使用Gzip压缩字节数组)
	 * @param src 需要压缩的字节数组
	 * @return 压缩后的字符串
	 * @throws IOException
	 */
	public static String gzip(byte[] src) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(baos);
		try {
			gzip.write(src);
			return new String(Base64.getEncoder().encode(baos.toByteArray()));
		}finally {
			if (gzip!=null)
				gzip.close();
			if (baos!=null)
				baos.close();
		}
	}

	/**
	 * gunzip(使用gzip进行解压缩)
	 * @param compressedStr 压缩的字符串
	 * @return 解压缩后的字符串
	 * @throws IOException
	 */
	public static byte[] ungzip(String compressedStr) throws IOException {
		byte[] compressed = Base64.getDecoder().decode(compressedStr.getBytes());
		ByteArrayInputStream in = new ByteArrayInputStream(compressed);
		GZIPInputStream ginzip = new GZIPInputStream(in);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try{
			byte[] buffer = new byte[1024];
			int offset = -1;
			while((offset = ginzip.read(buffer))!=-1){
				out.write(buffer, 0, offset);
			}
			return out.toByteArray();
		}finally{
			if(ginzip!=null){
				ginzip.close();
			}
			if(in!=null){
				in.close();
			}
			if(out!=null){
				out.close();
			}
		}
	}

	/**
	 * @param fileNameAndContent 待压缩的文件名称和文件内容
	 * @param targetFile 目标File
	 * @throws IOException
	 */
	public static void zip(Map<String, String> fileNameAndContent, File targetFile) 
			throws IOException {
		OutputStream os = new FileOutputStream(targetFile);
		ZipOutputStream zout = new ZipOutputStream(os);
		Iterator<String> iterator = fileNameAndContent.keySet().iterator();
		while(iterator.hasNext()){
			String fileName = iterator.next();
			String fileContent = fileNameAndContent.get(fileName);
			zout.putNextEntry(new ZipEntry(fileName));
			zout.write(fileContent.getBytes());
		}
		if(null!=zout)
			zout.close();
		if(null!=os)
			os.close();
	}

	/**
	 * zip(使用zip进行解压缩)
	 * @param src 待压缩的字节数组
	 * @return 压缩后的字符
	 * @throws IOException
	 */
	public static String zip(String src) throws IOException {
		return zip(src.getBytes());
	}

	/**
	 * zip(使用zip进行压缩)
	 * @param str 待压缩的字节数组
	 * @return 压缩后的字符
	 * @throws IOException
	 */
	public static String zip(byte[] str) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ZipOutputStream zout = new ZipOutputStream(out);
		try {
			zout.putNextEntry(new ZipEntry("0"));
			zout.write(str);
			zout.closeEntry();
			byte[] compressed = out.toByteArray();
			return new String(Base64.getEncoder().encode(compressed));
		}finally {
			if(null!=zout)
				zout.close();
			if(null!=out)
				out.close();
		}
	}

	/**
	 * unzip(使用zip进行解压缩)
	 * @param compressedStr
	 * @return
	 * @throws IOException
	 */
	public static byte[] unzip(String compressedStr) throws IOException {
		byte[] compressed = Base64.getDecoder().decode(compressedStr.getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(compressed);
		ZipInputStream zin = new ZipInputStream(in);
		try {
			zin.getNextEntry();
			byte[] buffer = new byte[1024];
			int offset = -1;
			while ((offset = zin.read(buffer)) != -1) {
				out.write(buffer, 0, offset);
			}
			return out.toByteArray();
		}finally{
			if (null!=zin){
				zin.close();
			}
			if (null!=in){
				in.close();
			}
			if (null!=out){
				out.close();
			}
		}
	}

	/**
	 * zip(对文件或文件目录进行压缩 )
	 * @param srcFile 需要压缩的File
	 * @param targetZipFile 压缩后的Zip
	 * @throws IOException 
	 * @throws Exception
	 */
	public static void zip(File srcFile, File targetZipFile) throws IOException {
		FileOutputStream fos = new FileOutputStream(targetZipFile);
		ZipOutputStream zos = new ZipOutputStream(fos);
		try{
			if (srcFile.isFile()){
				zos.putNextEntry(new ZipEntry(srcFile.getName()));
				byte[] buffer = new byte[1024];
				int offset = -1;
				BufferedInputStream bis = 
						new BufferedInputStream(new FileInputStream(srcFile));
				while((offset = bis.read(buffer))!=-1){
					zos.write(buffer, 0, offset);
				}
				if(null!=bis)
					bis.close();
			}else{
				zip(srcFile.getPath(), srcFile, zos);
			}
		}finally{
			if (null!=zos){
				zos.close();
			}
			if (null!=fos){
				fos.close();
			}
		}  
	}

	/** 
	 * 递归压缩文件夹
	 * @param srcRootDir 压缩文件夹根目录的子路径
	 * @param file 当前递归压缩的文件或目录对象
	 * @param zos 压缩文件存储对象
	 * @throws IOException
	 */  
	private static void zip(String srcRootDir, File file, ZipOutputStream zos) throws IOException{ 
		if(file.isFile()){     
			int count, bufferLen = 1024;
			byte data[] = new byte[bufferLen];
			String subPath = file.getAbsolutePath();
			int index = subPath.indexOf(srcRootDir);
			if (index!=-1)
				subPath = subPath.substring(srcRootDir.length()+File.separator.length());
			ZipEntry entry = new ZipEntry(subPath);
			zos.putNextEntry(entry);
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			while((count = bis.read(data, 0, bufferLen))!=-1){  
				zos.write(data, 0, count);
			}
			bis.close();
			zos.closeEntry();
		}else{
			File[] childFileList = file.listFiles();
			for (int n=0; n<childFileList.length; n++){
				childFileList[n].getAbsolutePath().indexOf(file.getAbsolutePath());
				zip(srcRootDir, childFileList[n], zos);
			}
		}
	}
	
    /**
     * unzip(解压缩zip包)
     * @param zipFile 带解压的Zip文件
     * @param unzipFile 解压后保存的文件
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
	public static void unzip(File zipFile, File unzipFile) throws IOException{
    	String unzipFilePath = unzipFile.getPath();
        int index = 0, count = 0, bufferSize = 1024;  
        byte[] buffer = new byte[bufferSize];  
        ZipFile zip = new ZipFile(zipFile);
        Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>)zip.entries();  
        while(entries.hasMoreElements()){
        	ZipEntry entry = entries.nextElement();  
        	String entryFilePath = unzipFilePath + File.separator + entry.getName();
            index = entryFilePath.lastIndexOf(File.separator);
            String entryDirPath = null;
            if (index!=-1){
                entryDirPath = entryFilePath.substring(0, index);
            }else{
                entryDirPath = "";
            }
            File entryDir = new File(entryDirPath);
            if(!entryDir.exists() || !entryDir.isDirectory()){
                entryDir.mkdirs();
            }
            File entryFile = new File(entryFilePath);
            if (entryFile.exists()){  
                entryFile.delete();   
            }  
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(entryFile));  
            BufferedInputStream bis = new BufferedInputStream(zip.getInputStream(entry));  
            while((count = bis.read(buffer, 0, bufferSize))!=-1){
                bos.write(buffer, 0, count);
            }
            bos.flush();
            if(null!=bis)
            	bis.close();
            if(null!=bos)
            	bos.close();
        }
        if(null!=zip)
        	zip.close();
    }
    
    /**
     * getZipFileContent(获取Zip文件中某个文件的内容，默认UTF-8编码)
     * @param zipFile zip文件
     * @param fileName 需要获取内容的文件名
     * @return 文件内容
     * @throws IOException
     */
    public static String getZipFileContent(File zipFile, String fileName) throws IOException{
    	return getZipFileContent(zipFile, fileName, "UTF-8");
    }
    
	/**
	 * getZipFileContent(获取Zip文件中某个文件的内容)
	 * @param zipFile zip文件
	 * @param fileName 需要获取内容的文件名
	 * @param charset 文件字符编码
	 * @return 文件内容
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static String getZipFileContent(File zipFile, String fileName, 
			String charset) throws IOException{
        int count = 0, bufferSize = 1024;  
        byte[] buffer = new byte[bufferSize];  
        ZipFile zip = new ZipFile(zipFile);
        Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>)zip.entries();  
        while(entries.hasMoreElements()){
        	ZipEntry entry = entries.nextElement();
        	String entryName = entry.getName();
        	if(!entry.isDirectory()){
        		String name = entryName;
        		if(entryName.indexOf(File.separator)>-1)
        			name = entryName.substring(entryName.lastIndexOf(File.separator)+1);
        		if(fileName.equals(name)){
        			ByteArrayOutputStream out = new ByteArrayOutputStream();
                    BufferedInputStream bis = new BufferedInputStream(zip.getInputStream(entry));  
                    while((count = bis.read(buffer, 0, bufferSize))!=-1){
                    	out.write(buffer, 0, count);
                    }
                    out.flush();
                    if(null!=bis)
                    	bis.close();
                    if(null!=out)
                    	out.close();
                    if(null!=zip)
                    	zip.close();
                    return out.toString(charset);
        		}
        	}
        }
        if(null!=zip)
        	zip.close();
        return null;
    }
    
}


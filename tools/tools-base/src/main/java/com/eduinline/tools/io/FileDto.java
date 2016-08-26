package com.eduinline.tools.io;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>封装文件File对象,使每个File对象信息以更直接的树形结构展示</p>
 *
 * @author hongze.he@eduinline.com
 * @version 1.0 2016年4月26日-下午9:41:39
 */
public class FileDto {
	/** 是否可读 */
	private boolean canRead;
	
	/** 是否可写 */
	private boolean canWrite;
	
	/** 绝对路径名字符串 */
	private String absolutePath;
	
	/** 总空间 */
	private long totalSpace;
	
	/** 空闲空间 */
	private long freeSpace;
	
	/** 父目录的路径名字符串 */
	private String parent;
	
	/** 是否为目录 */
	private boolean directory;
	
	/** 是否为文件 */
	private boolean file;
	
	/** 是否隐藏 */
	private boolean hidden;
	
	/** 子文件和目录 */
	private List<FileDto> children = new ArrayList<FileDto>();
	
	public boolean isCanRead() {
		return canRead;
	}
	public void setCanRead(boolean canRead) {
		this.canRead = canRead;
	}
	public boolean isCanWrite() {
		return canWrite;
	}
	public void setCanWrite(boolean canWrite) {
		this.canWrite = canWrite;
	}
	public String getAbsolutePath() {
		return absolutePath;
	}
	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}
	public long getTotalSpace() {
		return totalSpace;
	}
	public void setTotalSpace(long totalSpace) {
		this.totalSpace = totalSpace;
	}
	public long getFreeSpace() {
		return freeSpace;
	}
	public void setFreeSpace(long freeSpace) {
		this.freeSpace = freeSpace;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public boolean isDirectory() {
		return directory;
	}
	public void setDirectory(boolean directory) {
		this.directory = directory;
	}
	public boolean isFile() {
		return file;
	}
	public void setFile(boolean file) {
		this.file = file;
	}
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	public List<FileDto> getChildren() {
		return children;
	}
	public void setChildren(List<FileDto> children) {
		this.children = children;
	}
	
}

/* ***********************************************************************
 * Copyright (C) 1992-2016 中国南方航空股份有限公司.
 *
 * Created [2016年2月22日 下午12:18:30] by FMS Team
 * ***********************************************************************
 *
 * tools-base
 * ***********************************************************************
 */
package com.eduinline.tools.base.system;

/**
 * <p>com.helizfamily.tools.base.lang.WindowProcessInfo.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年2月22日-下午12:18:30
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose add this file description here
 */
public class ProcessInfo {
	/** 映像名称 */
	private String name;
	/** 进程ID */
	private int pid;
	/** 会话名称 */
	private String sessionName;
	/** 会话 */
	private int session;
	/** 内存使用 */
	private String ramUsed;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the pid
	 */
	public int getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}
	/**
	 * @return the sessionName
	 */
	public String getSessionName() {
		return sessionName;
	}
	/**
	 * @param sessionName the sessionName to set
	 */
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}
	/**
	 * @return the session
	 */
	public int getSession() {
		return session;
	}
	/**
	 * @param session the session to set
	 */
	public void setSession(int session) {
		this.session = session;
	}
	/**
	 * @return the ramUsed
	 */
	public String getRamUsed() {
		return ramUsed;
	}
	/**
	 * @param ramUsed the ramUsed to set
	 */
	public void setRamUsed(String ramUsed) {
		this.ramUsed = ramUsed;
	}
}


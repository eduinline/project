package com.eduinline.tools.base.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>com.helizfamily.tools.base.lang.RuntimeUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年2月22日-上午10:19:04
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose 运行时工具类。包括执行命令行和获取进程信息等
 */
public class ProcessUtil {

	public static final String TASK_LIST = "tasklist";

	/**
	 * getProcess(根据命令获取进行)
	 * @param cmd 执行的命令
	 * @return
	 * @throws IOException
	 */
	public static Process getProcess(String cmd) throws IOException{
		return Runtime.getRuntime().exec(cmd);
	}

	/**
	 * getWindowTaskList(获取Window系统的进程列表)
	 * @return List<ProcessInfo>
	 * @throws IOException
	 */
	public static List<ProcessInfo> getWindowTaskList() throws IOException{
		List<ProcessInfo> processList = new ArrayList<ProcessInfo>();
		Process p = Runtime.getRuntime().exec(TASK_LIST);
		BufferedReader bw = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String[] standar = null;
		int oneLen = 0, twoLen=0, threeLen=0, fourLen=0;
		String line;
		int lineNum = 1;
		while((line = bw.readLine())!=null){
			//拆分行规则
			if(lineNum==3){
				standar = line.split(" ");
				oneLen = standar[0].length();
				twoLen = oneLen+standar[1].length()+1;
				threeLen = twoLen+standar[2].length()+1;
				fourLen = threeLen+standar[3].length()+1;
			}
			//根据规则拆分行
			if(lineNum>3){
				String name = line.substring(0, oneLen).trim();
				String pid = line.substring(oneLen, twoLen).trim();
				String sessionName = line.substring(twoLen, threeLen).trim();
				String session = line.substring(threeLen, fourLen).trim();
				String ramUsed = line.substring(fourLen).trim();
				ProcessInfo wp = new ProcessInfo();
				wp.setName(name);
				wp.setPid(Integer.valueOf(pid));
				wp.setSessionName(sessionName);
				wp.setSession(Integer.valueOf(session));
				wp.setRamUsed(ramUsed);
				processList.add(wp);
			}
			lineNum++;
		}
		return processList;
	}
	
	/**
	 * getCurrentJavaProcess(获取当前代码的JAVA进程)
	 * @return
	 * @throws IOException
	 */
	public static ProcessInfo getCurrentJavaProcess() throws IOException{
		String name = ManagementFactory.getRuntimeMXBean().getName();
		String pid = name.split("@")[0];
		List<ProcessInfo> processList = getWindowTaskList();
		for (ProcessInfo processInfo : processList) {
			if(processInfo.getPid()==Integer.valueOf(pid))
				return processInfo;
		}
		return null;
	}
	
}


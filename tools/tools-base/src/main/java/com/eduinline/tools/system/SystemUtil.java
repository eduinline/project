package com.eduinline.tools.system;

import java.io.File;
import java.util.Properties;

/**
 * <p>com.helizfamily.tools.base.lang.SystemUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年3月18日-下午4:38:52
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose 获取系统信息工具类。
 */
public class SystemUtil {
	
	/** 文件系统分行符 */
	public static final String lineSeparator = System.lineSeparator();
	
	/** 目录路径分隔符 */
	public static final String fileSeparator = File.separator;
	
	/**
	 * 获取系统属性列表
	 * @return 系统属性
	 */
	public static Properties getProps(){
		return System.getProperties();
	}

	/**
	 * 根据Key获取系统属性，属性列表如下：
	 * <dl>
	 * <dt>java.version         <dd>Java version number
	 * <dt>java.vendor          <dd>Java vendor specific string
	 * <dt>java.vendor.url      <dd>Java vendor URL
	 * <dt>java.home            <dd>Java installation directory
	 * <dt>java.class.version   <dd>Java class version number
	 * <dt>java.class.path      <dd>Java classpath
	 * <dt>os.name              <dd>Operating System Name
	 * <dt>os.arch              <dd>Operating System Architecture
	 * <dt>os.version           <dd>Operating System Version
	 * <dt>file.separator       <dd>File separator ("/" on Unix)
	 * <dt>path.separator       <dd>Path separator (":" on Unix)
	 * <dt>line.separator       <dd>Line separator ("\n" on Unix)
	 * <dt>user.name            <dd>User account name
	 * <dt>user.home            <dd>User home directory
	 * <dt>user.dir             <dd>User's current working directory
	 * </dl>
	 * @param key
	 * @return
	 */
	public static String getProp(String key){
		return System.getProperty(key);
	}

	/**
	 * 获取系统环境信息
	 * @return Map 系统环境信息
	 */
	public static java.util.Map<String,String> getenv(){
		return System.getenv();
	}

	/**
	 * 根据Name获取系统环境值
	 * <dt>USERDOMAIN_ROAMINGPROFILE    <dd>USER
	 * <dt>LOCALAPPDATA                 <dd>C:\Users\footmark\AppData\Local
	 * <dt>PROCESSOR_LEVEL              <dd>6
	 * <dt>FP_NO_HOST_CHECK             <dd>NO
	 * <dt>USERDOMAIN                   <dd>USER
	 * <dt>LOGONSERVER                  <dd>\\MicrosoftAccount
	 * <dt>JAVA_HOME                    <dd>C:\Program Files\Java\jdk1.7.0_79\
	 * <dt>SESSIONNAME                  <dd>Console
	 * <dt>ALLUSERSPROFILE              <dd>C:\ProgramData
	 * <dt>PROCESSOR_ARCHITECTURE       <dd>AMD64
	 * <dt>PSModulePath                 <dd>C:\Windows\system32\WindowsPowerShell\v1.0\Modules\
	 * <dt>SystemDrive                  <dd>C:
	 * <dt>MAVEN_HOME                   <dd>E:\Software\Apache-maven-3.2.1
	 * <dt>=C:                          <dd>C:\
	 * <dt>APPDATA                      <dd>C:\Users\footmark\AppData\Roaming
	 * <dt>USERNAME                     <dd>footmark
	 * <dt>ProgramFiles(x86)            <dd>C:\Program Files (x86)
	 * <dt>CommonProgramFiles           <dd>C:\Program Files\Common Files
	 * <dt>Path                 		<dd>C:/Program Files/Java/jre1.8.0_45/bin/server;C:/Program Files/Java/jre1.8.0_45/bin;C:/Program Files/Java/jre1.8.0_45/lib/amd64;C:\ProgramData\Oracle\Java\javapath;C:\Program Files (x86)\Intel\iCLS Client\;C:\Program Files\Intel\iCLS Client\;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Program Files\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files\Java\jdk1.7.0_79\\bin;E:\Software\Apache-maven-3.2.1\bin;E:\Software\SSHClient\SSH Secure Shell3.2.9;E:\Software\Eclipse;
	 * <dt>PATHEXT                 		<dd>.COM;.EXE;.BAT;.CMD;.VBS;.VBE;.JS;.JSE;.WSF;.WSH;.MSC
	 * <dt>OS                 			<dd>Windows_NT
	 * <dt>classpath                 	<dd>.;C:\Program Files\Java\jdk1.7.0_79\\lib;C:\Program Files\Java\jdk1.7.0_79\\lib\dt.jar;C:\Program Files\Java\jdk1.7.0_79\\lib\tools.jar
	 * <dt>COMPUTERNAME                 <dd>USER
	 * <dt>PROCESSOR_REVISION           <dd>3d04
	 * <dt>CommonProgramW6432           <dd>C:\Program Files\Common Files
	 * <dt>NLS_LANG                 	<dd>AMERICAN_AMERICA.UTF8
	 * <dt>ComSpec                 		<dd>C:\Windows\system32\cmd.exe
	 * <dt>ProgramData                 	<dd>C:\ProgramData
	 * <dt>ProgramW6432                 <dd>C:\Program Files
	 * <dt>HOMEPATH                 	<dd>\Users\footmark
	 * <dt>SystemRoot                 	<dd>C:\Windows
	 * <dt>TEMP                 		<dd>C:\Users\footmark\AppData\Local\Temp
	 * <dt>HOMEDRIVE                 	<dd>C:
	 * <dt>PROCESSOR_IDENTIFIER         <dd>Intel64 Family 6 Model 61 Stepping 4, GenuineIntel
	 * <dt>USERPROFILE                  <dd>C:\Users\footmark
	 * <dt>TMP                 			<dd>C:\Users\footmark\AppData\Local\Temp
	 * <dt>CommonProgramFiles(x86)      <dd>C:\Program Files (x86)\Common Files
	 * <dt>ProgramFiles                 <dd>C:\Program Files
	 * <dt>PUBLIC                 		<dd>C:\Users\Public
	 * <dt>NUMBER_OF_PROCESSORS         <dd>4
	 * <dt>windir                 		<dd>C:\Windows
	 * <dt>=::                 			<dd>::\
	 * @param name 环境变量名
	 * @return 环境变量值
	 */
	public static String getenv(String name) {
		return System.getenv(name);
	}

}

package com.eduinline.tools.base.lang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * <p>com.helizfamily.tools.base.lang.ThreadPollUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年2月24日-下午12:31:14
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose 常用线程池操作工具类。
 */
public class ThreadPoolBase {
	
	/**
	 * 使用parallelism创建固定线程数的线程池。该池中水平并发处理线程为parallelism
	 * @param parallelism 水平并发处理线程数
	 * @return ExecutorService
	 * @since 1.8
	 */
	public static ExecutorService getWorkStealingPool(int parallelism){
		return Executors.newWorkStealingPool(parallelism);
	}
	
	/**
	 * 使用nThreads创建固定线程数的线程池。该池中核心线程和最大线程均为nThreads，存活时间0
	 * @param nThreads 设定的线程数
	 * @return ExecutorService
	 */
	public static ExecutorService getFixedThreadPool(int nThreads){
		return Executors.newFixedThreadPool(nThreads);
	}
	
	/**
	 * 创建一个单例线程池。池中只有一个唯一线程来处理任务队列。核心线程和最大线程均为1，存活时间0
	 * @return ExecutorService
	 */
	public static ExecutorService getSingleThreadExecutor(){
		return Executors.newSingleThreadExecutor();
	}
	
	/**
	 * 创建缓存线程池，核心线程为0，最大线程为Integer.MAX_VALUE，线程存活时间60s
	 * @return ExecutorService
	 */
	public static ExecutorService getCachedThreadPool(){
		return Executors.newCachedThreadPool();
	}
	
	/**
	 * 创建周期执行线程池，核心线程为0，最大线程为Integer.MAX_VALUE，线程存活时间60s
	 * @param corePoolSize 核心线程数
	 * @return ScheduledExecutorService
	 */
	public static ScheduledExecutorService getScheduledThreadPool(int corePoolSize){
		return Executors.newScheduledThreadPool(corePoolSize);
	}
	
}


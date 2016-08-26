package com.eduinline.tools.thread;

/**
 * <p>com.helizfamily.tools.base.lang.ThreadUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年2月22日-下午2:28:06
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose 线程工具类。包括对线程、线程变量、线程池的操作处理。
 * 
 */
public class ThreadUtil {
	/**
	 * 线程优先级：1-5(默认)-10
	 * NEW 至今尚未启动的线程处于这种状态。 =new Thread();
	 * RUNNABLE Java虚拟机中就绪的线程处于这种状态。 =Thread.start();
	 * RUNNING Java虚拟机中运行的线程处于这种状态。 =Thread.run();
	 * BLOCKED 受阻塞并等待某个监视器锁的线程处于这种状态。 =进入synchronized块或者lock
	 * WAITING 无限期地等待另一个线程来执行某一特定操作的线程处于这种状态。 =wait(),join()
	 * TIMED_WAITING 等待另一个线程来执行取决于指定等待时间的操作的线程处于这种状态。=sleep(seconds),wait(seconds),join(seconds)
	 * TERMINATED 已退出或异常中断的线程处于这种状态。=interrupt(),run()结束
	 */

	/** 全局ThreadLocal */
	private static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

	/**
	 * setThreadLocal(设置线程值。一旦设置，在该线程运行到任意位置都可以获取值。)
	 * 注意：线程内存是从JAVA进程中分配得到的，所以此处设置的值应尽量简小，以免占据太多内存。
	 * @param obj 需要设置的值
	 */
	public static void setThreadLocal(Object obj){
		threadLocal.set(obj);
	}

	/**
	 * getThreadLocal(获取线程值)
	 * @return 获取线程变量值
	 */
	public static Object getThreadLocal(){
		return threadLocal.get();
	}
	
	/**
	 * 使当前线程休眠。交出CPU，让CPU去执行其他的任务。sleep方法不会释放锁，也就是说如果当前线程持有对某个对象的锁，
	 * 则即使调用sleep方法，其他线程也无法访问这个对象
	 * @param millis
	 * @throws InterruptedException
	 */
	public static void sleep(long millis) throws InterruptedException{
		Thread.currentThread();
		Thread.sleep(millis);
	}
	
	/**
	 * 使当前线程休眠。交出CPU，让CPU去执行其他的任务。yield方法不会释放锁，也就是说如果当前线程持有对某个对象的锁，
	 * 则即使调用yield方法，其他线程也无法访问这个对象。注意：yield方法只能让拥有相同优先级的线程有获取CPU执行时间的机会
	 * @throws InterruptedException
	 */
	public static void yield() throws InterruptedException{
		Thread.currentThread();
		Thread.yield();
	}
	
	/**
	 * join(主线程等待t线程执行完之后才继续执行)
	 * @param t 需要先之执行完的线程
	 * @throws InterruptedException
	 */
	public static void join(Thread t) throws InterruptedException{
		t.join();
	}
	
	/**
	 * join(主线程等待t线程执行millis时间之后才继续执行)
	 * @param t 需要先之执行完的线程
	 * @param millis 等待的时间
	 * @throws InterruptedException
	 */
	public static void join(Thread t, long millis) throws InterruptedException{
		t.join(millis);
	}
	
	/**
	 * 中断线程并返回最终处理结果。通过interrupt方法可以中断处于阻塞状态的线程，不能中断处于非阻塞状态的线程
	 * @param t 需要中断的线程
	 * @return true=成功中断；false=中断失败
	 */
	public static boolean interrupt(Thread t) {
		t.interrupt();
		return t.isInterrupted();
	}

}


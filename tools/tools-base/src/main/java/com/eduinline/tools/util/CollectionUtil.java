package com.eduinline.tools.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * <p>com.helizfamily.tools.base.util.CollectionUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年2月29日-下午4:51:50
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose Collection处理工具类
 */
public class CollectionUtil {

	/**
	 * 判断集合是否为空
	 * @param c 集合对象
	 * @return TRUE=空集合
	 */
	public static <E> boolean isEmpty(Collection<E> c){
		if(null==c || c.isEmpty())
			return true;
		return false;
	}

	/**
	 * 创建HashSet对象，非同步（线程不安全）。与Collection一样的接口，其不包含重复的元素，可包含null
	 * <br>转换为线程安全：Set s = Collections.synchronizedSet(new HashSet(...));
	 * @return HashSet
	 */
	public static <E> HashSet<E> hashSet(){
		return new HashSet<E>();
	}

	/**
	 * <strong>说明：</strong>
	 * 创建TreeSet对象，非同步（线程不安全），有序集合。与Collection一样的接口，其不包含重复的元素，可包含null
	 * <br>转换为线程安全：Set s = Collections.synchronizedSet(new HashSet(...));
	 * @return TreeSet
	 */
	public static <E> TreeSet<E> treeSet(){
		return new TreeSet<E>();
	}

	/**
	 * 创建TreeSet对象，非同步（线程不安全），有序集合。与Collection一样的接口，其不包含重复的元素，可包含null
	 * <br>转换为线程安全：Set s = Collections.synchronizedSet(new HashSet(...));
	 * @param comparator 自定义的排序器，Set中的元素会按照此排序器排序元素
	 * @return TreeSet
	 */
	public static <E> TreeSet<E> treeSet(Comparator<? super E> comparator){
		return new TreeSet<E>(comparator);
	}

	/**
	 * 创建ArrayList对象，非同步（线程不安全）。允许重复的元素，可包含null
	 * <br>转换为线程安全：List list = Collections.synchronizedList(new ArrayList(...));
	 * <br>与Set的区别主要是多了索性index;与Vector的区别是Vector是线程安全的。
	 * @return ArrayList
	 */
	public static <E> ArrayList<E> arrayList(){
		return new ArrayList<E>();
	}

	/**
	 * 创建LinkedList对象，非同步（线程不安全）。允许重复的元素，可包含null
	 * <br>转换为线程安全：List list = Collections.synchronizedList(new LinkedList(...));
	 * <br>与ArrayList的区别主要是多了对头和队尾的操作，实现了Queue和Deque接口
	 * @return LinkedList
	 */
	public static <E> LinkedList<E> linkedList(){
		return new LinkedList<E>();
	}

	/**
	 * 创建vector对象，同步（线程安全）。允许重复的元素，可包含null
	 * <br>与ArrayList除了同步区别，无其他区别特性
	 * @return Vector
	 */
	public static <E> Vector<E> vector(){
		return new Vector<E>();
	}

	/**
	 * 创建后进先出（LIFO）的对象堆栈，继承Vector,同步（线程安全）。允许重复的元素，可包含null。
	 * <br>Deque接口及其实现提供了 LIFO堆栈操作的更完整和更一致的 set，应该优先使用此set。
	 * <br>在Vector的基础上增加5个方法实现堆栈操作功能：
	 * <br>empty():测试堆栈是否为空
	 * <br>peek():查看堆栈顶部的对象，但不从堆栈中移除它
	 * <br>pop():移除堆栈顶部的对象，并作为此函数的值返回该对象
	 * <br>push(E item):把数据项压入堆栈顶部
	 * <br>search(Object o):返回对象在堆栈中的位置，以 1 为基数
	 * @return Stack
	 */
	public static <E> Stack<E> stack(){
		return new Stack<E>();
	}

	/**
	 * 创建一个由数组支持的有界阻塞队列,带有给定的（固定）容量和默认访问策略(FIFO)。不允许插入null
	 * <br>注意put()和task()方法：主要是进行了等待
	 * @param capacity 队列容量
	 * @return ArrayBlockingQueue
	 */
	public static <E> ArrayBlockingQueue<E> arrayBlockingQueue(int capacity){
		return new ArrayBlockingQueue<E>(capacity);
	}

	/**
	 * 一个基于链接节点的无界线程安全队列。此队列按照 FIFO（先进先出）原则对元素进行排序。不允许插入null
	 * @return ConcurrentLinkedQueue
	 */
	public static <E> ConcurrentLinkedQueue<E> concurrentLinkedQueue(){
		return new ConcurrentLinkedQueue<E>();
	}

	/**
	 * Delayed元素的一个无界阻塞队列，只有在延迟期满时才能从中提取元素。不允许插入null
	 * <br>当一个Delayed元素的 getDelay(TimeUnit.NANOSECONDS) 方法返回一个小于等于 0 的值时，将发生到期
	 * @return DelayQueue
	 */
	public static <E extends Delayed> DelayQueue<E> delayQueue(){
		return new DelayQueue<E>();
	}

	/**
	 * 一个基于已链接节点的、范围任意的 blocking queue。此队列按 FIFO（先进先出）排序元素。不允许插入null
	 * <br>链接队列的吞吐量通常要高于基于数组的队列，但是在大多数并发应用程序中，其可预知的性能要低
	 * @return LinkedBlockingQueue
	 */
	public static <E> LinkedBlockingQueue<E> linkedBlockingQueue(){
		return new LinkedBlockingQueue<E>();
	}

	/**
	 *  一个无界阻塞队列，它使用与类 PriorityQueue相同的顺序规则(自然顺序)，并且提供了阻塞获取操作。不允许插入null
	 *  <br>如果需要有序地进行遍历，则应考虑使用 Arrays.sort(pq.toArray())。
	 * @return PriorityBlockingQueue
	 */
	public static <E> PriorityBlockingQueue<E> priorityBlockingQueue(){
		return new PriorityBlockingQueue<E>();
	}

	/**
	 *  一个无界阻塞队列，它使用与类 PriorityQueue 相同的顺序规则，并且提供了阻塞获取操作。不允许插入null
	 *  <br>如果需要有序地进行遍历，则应考虑使用 Arrays.sort(pq.toArray())。
	 * @param comparator 自定义的比较器，队列会按照此比较器排列元素
	 * @return PriorityBlockingQueue
	 */
	public static <E> PriorityBlockingQueue<E> priorityBlockingQueue(Comparator<? super E> comparator){
		return new PriorityBlockingQueue<E>(20, comparator);
	}

	/**
	 *  一个基于优先级堆的无界优先级队列,不允许插入null。依靠自然顺序的优先级队列还不允许插入不可比较的对象
	 *  <br>如果需要有序地进行遍历，则应考虑使用 Arrays.sort(pq.toArray())。
	 * @return PriorityQueue
	 */
	public static <E> PriorityQueue<E> priorityQueue(){
		return new PriorityQueue<E>();
	}

	/**
	 *  一个基于优先级堆的无界优先级队列,不允许插入null。依靠自然顺序的优先级队列还不允许插入不可比较的对象
	 *  <br>如果需要有序地进行遍历，则应考虑使用 Arrays.sort(pq.toArray())。
	 * @param comparator 自定义的比较器，队列会按照此比较器排列元素
	 * @return PriorityQueue
	 */
	public static <E> PriorityQueue<E> priorityQueue(Comparator<? super E> comparator){
		return new PriorityQueue<E>(20, comparator);
	}

	/**
	 *  一种阻塞队列，其中每个插入操作必须等待另一个线程的对应移除操作 ，反之亦然。同步队列没有任何内部容量，甚至连一个队列的容量都没有
	 *  <br>同步队列类似于 CSP 和 Ada 中使用的 rendezvous 信道。它非常适合于传递性设计，在这种设计中，
	 *  <br>在一个线程中运行的对象要将某些信息、事件或任务传递给在另一个线程中运行的对象，它就必须与该对象同步
	 * @return SynchronousQueue
	 */
	public static <E> SynchronousQueue<E> synchronousQueue(){
		return new SynchronousQueue<E>();
	}

	/**
	 *  Deque 接口的大小可变数组的实现。数组双端队列没有容量限制；它们可根据需要增加以支持使用。它们不是线程安全的
	 *  <br>此类很可能在用作堆栈时快于 Stack，在用作队列时快于 LinkedList
	 * @return ArrayDeque
	 */
	public static <E> ArrayDeque<E> arrayDeque(){
		return new ArrayDeque<E>();
	}

	/**
	 *  一个基于已链接节点的、任选范围的<strong>阻塞</strong>双端队列。 
	 * @return LinkedBlockingDeque
	 */
	public static <E> LinkedBlockingDeque<E> linkedBlockingDeque(){
		return new LinkedBlockingDeque<E>();
	}

	/**
	 * <p>对List进行分页处理，返回Map&ltpageNumber, List&ltE>></p>
	 * @param list 需要分页的集合
	 * @param pageSize 每页的数据量
	 * @return LinkedHashMap<Integer, List<E>> 页数从1开始
	 */
	public <E> LinkedHashMap<Integer, List<E>> pageList2Map(
			List<E> list, int pageSize) {
		LinkedHashMap<Integer, List<E>> map = new LinkedHashMap<Integer, List<E>>();
		if(null==list || list.isEmpty()){
			map.put(1, new ArrayList<E>());
		}else{
			int size = list.size();
			int pageNumber = size/pageSize;
			int remainder = size%pageSize;
			if(remainder!=0){
				pageNumber++;
			}
			for(int i=0; i<pageNumber; i++){
				List<E> subList = new ArrayList<E>();
				if (remainder!=0 && (i==pageNumber-1)) {
					subList = list.subList(i * (pageNumber-1), list.size());
				} else {
					subList = list.subList(i * (pageNumber-1), (pageNumber-1) * (i + 1));
				}
				map.put(i+1, subList);
			}
		}
		return map;
	}

}


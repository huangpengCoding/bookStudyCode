package chapter3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/4/10 5:04 PM
 * @Usage: 线程池
 * newFixedThreadPoll(): 该方法返回一个固定线程数量的线程池 如当前没有
 * 空闲线程 则新的人呢无会被暂存在一个任务队列中
 * newSinglethreadExecutor(): 改方法返回一个只有一个线程的线程池 若多余一个任务被提交到改线程池 任务
 * 会被保存在一个任务队列中 待线程空闲 按先入先出的顺序执行队列中的任务
 * newCachedThreadPool(): 该方法返回一个可根据实际情况调整线程数量的线程池
 */
public class ThreadPoolDemo {
    public static class MyTask implements Runnable {

        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            MyTask task = new MyTask();
//            ExecutorService es = Executors.newFixedThreadPool(5);
            ExecutorService es = Executors.newCachedThreadPool();
            for (int i = 0; i < 10; i++) {
                es.submit(task);
            }
            es.shutdown();   //不加这个主线程结束不了
        }
    }
}

package chapter3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/4/10 3:11 PM
 * @Usage: 信号量的使用
 * 信号量为多线程协作提供了更为强大的控制方法 从广义上说 信号量是对锁的扩展
 * 无论是内部锁synchronized 还是重入锁 ReentrantLock 一次都只允许一个线程访问一个资源
 * 而信号量却可以指定多个线程 同时访问耨一个资源
 */
public class SemapDemo implements Runnable {

    final Semaphore semp = new Semaphore(5);   //同时允许5个线程进入

    public void run() {
        try {
            semp.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ":done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semp.release();
        }
    }


    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemapDemo demo = new SemapDemo();
        for (int i = 0; i < 20; i++) {
            exec.submit(demo);
        }
    }
}




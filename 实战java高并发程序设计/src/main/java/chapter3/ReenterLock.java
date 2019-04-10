package chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/4/6 9:54 PM
 * @Usage: 重入锁  这种方式可以替换synchorized wait notify
 *
 * 备注：为什么叫重入锁 是因为这种锁 对同一个线程来说 是可以重复进入的
 */
public class ReenterLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    public void run() {
        for (int j = 0; j < 1000000; j++) {
            lock.lock();
//            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
//                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock tl = new ReenterLock();
        Thread t1 = new Thread(tl);   //传入重入锁对象
        Thread t2 = new Thread(tl);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}

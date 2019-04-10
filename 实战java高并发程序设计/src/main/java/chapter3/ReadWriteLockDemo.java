package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/4/10 4:04 PM
 * @Usage:
 */
public class ReadWriteLockDemo {

    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;

    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();        //模拟读
            Thread.sleep(1000);
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, int index) throws InterruptedException {
        try {
            lock.lock();        //模拟写
            Thread.sleep(1000);
            value = index;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = new Runnable() {
            public void run() {
                try {
//                    demo.handleRead(readLock);
                    demo.handleRead(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunnable = new Runnable() {
            public void run() {
                try {
//                    demo.handleWrite(writeLock, new Random().nextInt());    //不使用读写锁 时间会长达20s左右
                    demo.handleWrite(lock, new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        long start = System.currentTimeMillis();
        List<Thread> lis = new ArrayList<Thread>();
        for (int i = 0; i < 18; i++) {
            Thread t = new Thread(readRunnable);
            t.start();
            lis.add(t);
        }

        for (int i = 18; i < 20; i++) {
            Thread t = new Thread(writeRunnable);
            t.start();
            lis.add(t);
        }
        for (Thread t : lis) {
            t.join();
        }
        System.out.println("[cost time] " + (System.currentTimeMillis() - start));
    }
}

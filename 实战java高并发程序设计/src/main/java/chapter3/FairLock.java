package chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/4/10 2:01 PM
 * @Usage: 公平锁使用
 */
public class FairLock implements Runnable {

    public static ReentrantLock fairLock = new ReentrantLock(true);  //set fair

    public void run() {
        while(true){
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + " 获得锁");
            }finally {
                fairLock.unlock();
            }
        }
    }


    public static void main(String[] args) {

        FairLock r1 = new FairLock();
        Thread t1 = new Thread(r1, "Thread_t1");
        Thread t2 = new Thread(r1, "Thread_t2");
        t1.start();
        t2.start();

    }
}

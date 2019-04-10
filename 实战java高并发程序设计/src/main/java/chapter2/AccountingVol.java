package chapter2;

import sun.jvm.hotspot.runtime.Threads;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/4/6 6:38 PM
 * @Usage:
 */
public class AccountingVol implements Runnable {

    static AccountingVol instance = new AccountingVol();
    static volatile int i = 0;

    public static synchronized void increase() {
//        synchronized (instance) {     //这两者是等价的
            i++;
//        }
    }

    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AccountingVol());
        Thread t2 = new Thread(new AccountingVol());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}

package chapter4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/5/2 4:44 PM
 * @Usage:
 */
public class AtomicIntegerDemo {

    static AtomicInteger i = new AtomicInteger();

    public static class AddThread implements Runnable {
        @Override
        public void run() {
            for (int k = 0; k < 10000; k++) {
                i.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for(int k=0;k<10;k++){
            ts[k] = new Thread(new AddThread());
        }
        for(Thread t : ts){
            t.start();
        }
        for(Thread t : ts){
            t.join();
        }
        System.out.println(i);
    }
}



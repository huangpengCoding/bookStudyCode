package chapter2;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/4/6 5:16 PM
 * @Usage:
 */
public class VolatileDemo1 {

    static volatile int i = 0;

    public static class PlusTask implements Runnable {

        public void run() {
            for (int k = 0; k < 10000; k++) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new PlusTask());
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println(i);  //最终值要小
    }
}

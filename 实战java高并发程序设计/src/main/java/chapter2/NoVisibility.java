package chapter2;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/4/6 5:30 PM
 * @Usage:
 */
public class NoVisibility {

    private static volatile boolean ready;
    private static int number;


    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                if(ready) {
                    System.out.println(number);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1000);
        number = 42;
        ready = true;
        Thread.sleep(1000);
    }
}

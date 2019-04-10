package chapter2;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/4/6 5:58 PM
 * @Usage: 设置守护线程
 * 如果不把t1设置为守护线程，那么Main线程结束后，t线程
 * 还会不停的打印,不会结束
 */
public class DaemonDemo {


    public static class DaemonT extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new DaemonT();
        t.setDaemon(true);
        t.start();
        Thread.sleep(2000);
    }
}



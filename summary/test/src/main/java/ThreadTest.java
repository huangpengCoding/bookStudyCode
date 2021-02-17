/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2021/2/15 4:22 PM
 * @Usage:
 */
public class ThreadTest {


    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Thread2()).start();
    }


    public static class Thread1 implements Runnable {

        public void run() {
            synchronized (ThreadTest.class) {

                System.out.println("进入thread1...");
                System.out.println("thread1是等待...");
                try {
                    ThreadTest.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1正在进行 ....");
                System.out.println("thread1结束!!!");
            }
        }
    }

    public static class Thread2 implements Runnable {
        public void run() {
            synchronized (ThreadTest.class) {
                System.out.println("进入thread2...");
                System.out.println("thread2是睡眠");
                ThreadTest.class.notify();
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2正在进行....");
            System.out.println("thread2结束!!!");
        }
    }


}

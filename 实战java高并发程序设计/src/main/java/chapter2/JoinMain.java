package chapter2;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/4/1 7:14 PM
 * @Usage:
 */
public class JoinMain {


    public volatile static int i = 0;

    public static class AddThread extends Thread {
        @Override
        public void run() {
            for (i = 0; i < 900000000; i++) ;

            System.out.println(">>>>" + i);
        }

    }


    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        addThread.start();
        addThread.join(3000);
        System.out.println(i);
    }
}

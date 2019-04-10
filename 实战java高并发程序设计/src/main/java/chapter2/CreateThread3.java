package chapter2;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/3/30 7:17 PM
 * @Usage:
 */
public class CreateThread3 implements Runnable {

    public static void main(String[] args) {
        Thread t1 = new Thread(new CreateThread3());
        t1.start();
    }

    public void run() {
        System.out.println("okokok");
    }
}

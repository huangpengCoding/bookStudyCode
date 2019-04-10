package chapter2;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/4/6 9:39 PM
 * @Usage:
 */
public class BadLockOnInteger implements Runnable {

    public static Integer i = 0;
    static BadLockOnInteger instance = new BadLockOnInteger();

    public void run() {
        for (int j = 0; j < 1000000; j++) {
//            synchronized (i) {        //Integer是不变对象 对象一但被创建就不会被修改
            synchronized (instance) {
                i++;                //实际上jvm里是new Integer()了
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}

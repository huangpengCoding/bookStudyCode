package chapter2;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/3/30 7:46 PM
 * @Usage:
 */
public class InterruptedDemo1 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true){
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Interrupted!");
                        break;
                    }
                    System.out.println("thread running..." + System.currentTimeMillis());
                    Thread.yield();
                }
            }
        };

        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}

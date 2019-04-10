package chapter2;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/3/30 7:52 PM
 * @Usage:
 */
public class SleepDemo1 {


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while(true){
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Interruted!");
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {      //sleep因为中断而抛出异常 此时它会清除中断状态
                        System.out.println("Interruted When Sleep");
                        //设置中断状态
                        Thread.currentThread().interrupt();         //所以这里必须要加，再次设置中断状态,否则还会循环
                    }
                    Thread.yield();
                }
            }
        };

        t1.start();
        Thread.sleep(1000);
        t1.interrupt();

    }
}

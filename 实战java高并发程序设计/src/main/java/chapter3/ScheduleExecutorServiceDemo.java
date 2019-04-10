package chapter3;

import java.sql.Time;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/4/10 5:38 PM
 * @Usage:
 */
public class ScheduleExecutorServiceDemo {

    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        //如果前面的任务没有完成 则调度也不会启动
        ses.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println(System.currentTimeMillis() / 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, 0, 2, TimeUnit.SECONDS);

    }
}

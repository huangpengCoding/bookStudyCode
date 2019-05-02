package chapter4;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/5/2 3:49 PM
 * @Usage: 测试使用threadlocal和不使用的情况下的耗时
结果:
pool-1-thread-3 spend126ms
pool-1-thread-1 spend138ms
pool-1-thread-4 spend133ms
pool-1-thread-2 spend150ms
多线程访问同一个Random实例:547ms
pool-1-thread-1 spend33ms
pool-1-thread-3 spend42ms
pool-1-thread-4 spend37ms
pool-1-thread-2 spend40ms
使用ThreadLocal包装Random实例:152ms
 */
public class ThreadLocalDemo2 {

    public static final int GEN_COUNT = 1000000;
    public static final int THREAD_COUNT = 4;
    static ExecutorService exe = Executors.newFixedThreadPool(THREAD_COUNT);
    public static Random rnd = new Random(123);

    public static ThreadLocal<Random> tRnd = new ThreadLocal<Random>() {
        @Override
        protected Random initialValue() {
            return new Random(123);
        }
    };

    public static class RndTask implements Callable<Long> {

        private int mode = 0;

        public RndTask(int mode) {
            this.mode = mode;
        }

        public Random getRandom() {
            if (mode == 0) {
                return rnd;
            } else if (mode == 1) {
                return tRnd.get();
            } else {
                return null;
            }
        }

        public Long call() throws Exception {
            long b = System.currentTimeMillis();
            for (long i = 0; i < GEN_COUNT; i++) {
                getRandom().nextInt();
            }
            long e = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " spend" + (e - b) + "ms");
            return e - b;
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Future<Long>[] futs = new Future[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            futs[i] = exe.submit(new RndTask(0));
        }

        long totalTime = 0;
        for (int i = 0; i <THREAD_COUNT; i++) {
            totalTime += futs[i].get();
        }
        System.out.println("多线程访问同一个Random实例:" + totalTime + "ms");

        //使用ThreadLocal
        for(int i=0;i<THREAD_COUNT;i++){
            futs[i] = exe.submit(new RndTask(1));
        }
        totalTime = 0;
        for (int i = 0; i <THREAD_COUNT; i++) {
            totalTime += futs[i].get();
        }
        System.out.println("使用ThreadLocal包装Random实例:" + totalTime + "ms");
    }
}

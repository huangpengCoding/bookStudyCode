package chapter3;


import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/4/11 11:25 AM
 * @Usage: forkJoin使用
 */
public class CountTask extends RecursiveTask<Long> {


    private static final int THREADHOLD = 10000;
    private long start;
    private long end;

    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THREADHOLD;
        if (canCompute) {
            for (long i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            long step = (start + end) / 100;
            ArrayList<CountTask> subTasks = new ArrayList<>();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                if (lastOne > end)
                    lastOne = end;
                CountTask subtask = new CountTask(pos, lastOne);
                pos += step + 1;
                subTasks.add(subtask);
                subtask.fork();
            }
            for (CountTask t : subTasks) {
                sum += t.join();
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(0, 200000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        try {
            Long res = result.get();
            System.out.println("sum=" + res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

package chapter2;

import java.util.ArrayList;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/4/6 9:24 PM
 * @Usage: ArrayList多线程不安全
 * 原因：
 * 这是因为ArrayList在扩容过程中 内部一致性被破坏 但由于没有锁的保护
 * 另外一个线程访问到了不一致的内部状态 导致出现越界问题
 * 多线程访问冲突 是的保存容器的大小变量被多线程不正常访问
 * 同时两个线程也对ArrayList中的同一个位置进行赋值导致
 *
 * 解决办法：
 * 用Vector
 */
public class ArrayListMultiThread {

    static ArrayList<Integer> al = new ArrayList<Integer>(10);

    public static class AddThread implements Runnable {
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                al.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AddThread());
        Thread t2 = new Thread(new AddThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(al.size());
    }
}

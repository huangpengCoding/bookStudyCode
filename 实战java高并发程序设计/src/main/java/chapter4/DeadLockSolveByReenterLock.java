package chapter4;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/5/2 5:23 PM
 * @Usage: 使用重入锁方式解决死锁问题
 */
public class DeadLockSolveByReenterLock extends Thread {

    public static ReentrantLock fork1 = new ReentrantLock();
    public static ReentrantLock fork2 = new ReentrantLock();

    private String name;

    public DeadLockSolveByReenterLock(String str) {
        this.name = str;
        if (str.equals("A")) {
            this.setName("哲学家A");
        }
        if (str.equals("B")) {
            this.setName("哲学家B");
        }
    }

    @Override
    public void run() {
        if (this.name.equals("A")) {
            try {
                fork1.lockInterruptibly();
                Thread.sleep(500);
                fork2.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (fork1.isHeldByCurrentThread()) {
                    fork1.unlock();
                }
                if (fork2.isHeldByCurrentThread()) {
                    fork2.unlock();
                }
            }
            System.out.println("哲学家A进餐完毕");
        }

        if (this.name.equals("B")) {
            try {
                fork2.lockInterruptibly();
                Thread.sleep(500);
                fork1.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (fork1.isHeldByCurrentThread()) {
                    fork1.unlock();
                }
                if (fork2.isHeldByCurrentThread()) {
                    fork2.unlock();
                }
            }
            System.out.println("哲学家B进餐完毕");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLockSolveByReenterLock deadlockA = new DeadLockSolveByReenterLock("A");
        DeadLockSolveByReenterLock deadlockB = new DeadLockSolveByReenterLock("B");
        deadlockA.start();
        deadlockB.start();
        Thread.sleep(2000);
        deadlockB.interrupt();
    }

}

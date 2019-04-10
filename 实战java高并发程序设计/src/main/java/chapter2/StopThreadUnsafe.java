package chapter2;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/3/30 7:22 PM
 * @Usage:
 */
public class StopThreadUnsafe {

    private static User u = new User();

    public static class User {
        private int id;
        private String name;

        public User() {
            id = 0;
            name = "0";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


    public static class ChangeObjectThread extends Thread {     //使用stop()方法造成线程不安全
        @Override
        public void run() {
            while (true) {
                synchronized (u) {
                    int v = (int) (System.currentTimeMillis() / 1000);
                    u.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ChangeObjectThread2 extends Thread {      //采用一个变量的方法使得退出线程安全

        volatile boolean stopme = false;

        public void stopMe() {
            stopme = true;
        }

        @Override
        public void run() {
            while (true) {
                if (stopme) {
                    System.out.println("exit by stop me");
                    break;
                }
                synchronized (u) {
                    int v = (int) (System.currentTimeMillis() / 1000);
                    u.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (u) {
                    if (u.getId() != Integer.parseInt(u.getName())) {
                        System.out.println(u.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadObjectThread().start();
        while (true) {
//            Thread t = new ChangeObjectThread();
//            t.start();
//            Thread.sleep(150);
//            t.stop();
            ChangeObjectThread2 changeObjectThread2 = new ChangeObjectThread2();
            changeObjectThread2.start();
            Thread.sleep(150);
            changeObjectThread2.stopMe();

        }
    }
}

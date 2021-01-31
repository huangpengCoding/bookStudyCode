package 算法.other.单例模式;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/5/19 4:39 PM
 * @Usage:
 */
public class  MainFunc {

    public static void main(String[] args) {
        SingleInstance instance = SingleInstance.getInstance();
        SingleInstance2 instance2 = SingleInstance2.getInstance();
        SingleInstance3.getInstance();
    }
}

//饿汉式
class SingleInstance {
    private static SingleInstance instance = new SingleInstance();

    private SingleInstance() {
    }

    public static SingleInstance getInstance() {
        return instance;
    }
}

//懒汉式+线程安全
class SingleInstance2 {
    private static volatile SingleInstance2 instance;

    private SingleInstance2() {
    }

    public static SingleInstance2 getInstance() {
        if (instance != null) {
            synchronized (SingleInstance2.class) {
                if (instance != null) {
                    instance = new SingleInstance2();
                }
            }
        }
        return instance;
    }
}

//内部Holder模式
class SingleInstance3 {
    private SingleInstance3() {
    }

    private static class SingleHolder {
        public static final SingleInstance3 instance = new SingleInstance3();
    }

    public static SingleInstance3 getInstance() {
        return SingleHolder.instance;
    }
}

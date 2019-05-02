package chapter5;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/5/2 6:16 PM
 * @Usage:
 */
public class StaticSingleton {
    private StaticSingleton() {
        System.out.println("StaticSingleton is create");
    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}

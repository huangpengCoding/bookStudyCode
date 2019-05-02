package chapter5;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/5/2 6:12 PM
 * @Usage:
 */
public class LazySingleton {

    private LazySingleton(){
        System.out.println("LazySingleton is create");
    }

    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}

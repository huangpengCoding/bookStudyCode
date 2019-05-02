package chapter5;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/5/2 6:03 PM
 * @Usage: 单例模式
 */
public class Singleton {

//    private Singleton(){}
//
//    private static Singleton instance = new Singleton();
//
//    public static Singleton getInstance(){
//        return instance;
//    }

//    private static volatile Singleton instance;
//
//    public static Singleton getInstance() {
//        if(instance == null){
//            instance = new Singleton();
//        }
//        return instance;
//    }


    private static volatile Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}

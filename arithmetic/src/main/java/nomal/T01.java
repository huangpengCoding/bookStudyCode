package nomal;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2021/3/9 3:40 PM
 * @Usage: 编写单例模式
 */
public class T01 {

    private volatile static T01 instance;

    private T01() {
    }

    public static T01 getInstance() {
        if (instance == null) {
            synchronized (T01.class) {
                if (instance == null) {
                    instance = new T01();
                }
            }
        }
        return instance;
    }

}

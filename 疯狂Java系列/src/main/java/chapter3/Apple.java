package chapter3;

import java.util.ArrayList;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/5/2 8:36 PM
 * @Usage: 对于每个java集合来说，其实它只是多个引用变量的集合
 */
public class Apple {

    double weight;

    public Apple(double weight) {
        this.weight = weight;
    }

    public static void main(String[] args) {
        Apple t1 = new Apple(2.2);
        Apple t2 = new Apple(1.8);
        ArrayList<Apple> list = new ArrayList<Apple>(4);
        list.add(t1);
        list.add(t2);
        System.out.println(list.get(0) == t1);
        System.out.println(list.get(1) == t2);
    }
}


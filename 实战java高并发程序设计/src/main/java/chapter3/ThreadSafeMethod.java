package chapter3;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/4/11 2:03 PM
 * @Usage:
 */
public class ThreadSafeMethod {

    public static void main(String[] args) {
        ////////hashmap线程不安全
        //1.使用ConcurrentHashMap
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        //2.使用Collections.synchronizedMap
        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());


        ////////ArrayList线程不安全
        //1.使用Vector
        Vector<Object> objects = new Vector<>();
        //2.使用Collections.synchronizedList
        List<Object> objects1 = Collections.synchronizedList(new ArrayList<>());
        //3.使用CopyOnWriteArrayList
        CopyOnWriteArrayList<Object> objects2 = new CopyOnWriteArrayList<>();

    }
}

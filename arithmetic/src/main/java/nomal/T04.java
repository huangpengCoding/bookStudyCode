package nomal;

import java.util.HashMap;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2021/3/11 7:38 PM
 * @Usage: LRUCache
 */
public class T04 {

    static class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();



}

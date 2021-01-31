package 算法.other.单链表反转;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/5/22 9:31 PM
 * @Usage:
 */
public class ReverseLinkNode {

    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        node1.setData(1);
        node1.setNext(node2);
        node2.setData(2);
        node2.setNext(node3);
        node3.setData(3);
        node3.setNext(node4);
        node4.setData(4);
        node4.setNext(node5);
        node5.setData(5);
        node5.setNext(null);
        //迭代法
        reverse1(node1);
        soutNodes(node5);
    }

    static void soutNodes(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.getData() + ">");
            cur = cur.getNext();
        }
    }


    static class Node {
        private int data;
        private Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    static void reverse1(Node head) {
        Node pre = null;
        Node now = head;
        while (now != null) {
            Node next = now.getNext();
            now.setNext(pre);
            pre = now;
            now = next;
        }
    }
}

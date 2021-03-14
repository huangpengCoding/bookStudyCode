package nomal;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2021/3/9 3:54 PM
 * @Usage: https://blog.csdn.net/weixin_40807247/article/details/91435275
 */
public class T02 {


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

//        showNodeData(node1);
        reverse2(node1);
        showNodeData(node4);

    }

    public static void showNodeData(Node head) {
        Node index = head;
        while (index != null) {
            System.out.println(index.data);
            index = index.next;
        }
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

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
    }

    public static Node reverse1(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node reverse2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head.next;
        Node newHead = reverse2(head.next);
        temp.next = head;
        head.next = null;
        return newHead;

    }

}

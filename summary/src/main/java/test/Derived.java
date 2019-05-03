package test;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/5/3 8:17 PM
 * @Usage:
 */
public class Derived extends test.Base {

    static {
        System.out.println("Derived static block");
    }
    {
        System.out.println("Derived block");
    }
    public Derived(){
        System.out.println("Derived constructor");
    }

    public static void main(String[] args) {
        new Derived();
    }
}

package test;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/5/3 8:20 PM
 * @Usage:
 */
public class Base {
    static {
        System.out.println("Base static block");
    }
    {
        System.out.println("Base block");
    }
    public Base(){
        System.out.println("Base constructor");
    }
}

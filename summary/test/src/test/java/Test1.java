/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2021/1/31 11:43 PM
 * @Usage:
 */
public class Test1 {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "def";
        String s3 = s1 + s2;
        System.out.println(s3 == "abcdef");
        System.out.println(s3.equals("abcdef"));
    }
}

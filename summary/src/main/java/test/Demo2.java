package test;

/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/5/3 9:03 PM
 * @Usage:
 */
public class Demo2 {

    public static int testFinally1(){
        int result = 1;
        try{
            result = 2;
            return result;
        }
        catch (Exception e){
            return 0;
        }
        finally {
            result = 3;   //没有return语句则不会更改真正的返回值
            System.out.println("execute finally1");
        }
    }

    public static  StringBuffer testFinally2(){
        StringBuffer s = new StringBuffer("Hello");
        try{
            return s;
        }catch (Exception e){
            return null;
        }finally {
            s.append(" World");
            System.out.println("execute finally2");
        }
    }

    public static void main(String[] args) {
        int res1 = testFinally1();
        System.out.println(res1);
        StringBuffer res2 = testFinally2();
        System.out.println(res2);
    }
}

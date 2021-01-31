

## 回答

   1. finally代码一定会被执行 而且是在return前
   2. 如果finally里没有return语句 那么更改return的基本类型变量 不会影响try中的返回值；如果finally里中有return语句 则会覆盖try中的return值
   3. 第二条需要考虑引用变量的情况，如果是引用变量，则会有变化
   4. 因为try执行完的时候，是吧变量拷贝存储在另一个地方 等待finally后返回，如果finnaly没有return,那么更改try中的这个值就是原始的值，并不是拷贝后要返回的值.但是引用型变量则不一样
 
```
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

```
返回

```
execute finally1
2
execute finally2
Hello World
```

### 补充
#### 什么情况下finally不会被执行呢?
    * 1.进入try之前就终止（异常等原因)
    * 2.try语句中强制终止(System.exit())
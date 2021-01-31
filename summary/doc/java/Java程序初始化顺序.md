

## 回答
   1. 父类静态变量
   2. 父类静态代码块
   3. 子类静态变量
   4. 子类静态代码块
   5. 父类非静态变量
   6. 父类非静态代码块
   7. 父类构造函数
   8. 子类非静态变量
   9. 子类非静态代码块
   10. 子类构造函数
   
   
```
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
```

输出

```
Base static block
Derived static block
Base block
Base constructor
Derived block
Derived constructor
```
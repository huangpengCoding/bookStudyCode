/**
 * @Author: huangpeng3
 * @Email: huangpeng3@staff.weibo.com
 * @Date: 2019/5/15 8:19 PM
 * @Usage: 实现单例模式
 */
public class No02 {
    //饿汉式
    A a = A.getInstance();
    //懒汉式
    B b = B.getInstance();
    //懒汉内部holder方式
    C c = C.getInstance();
}

class A {
    private static A a = new A();

    private A() {
    }

    public static A getInstance() {
        return a;
    }
}

class B {
    private static volatile B b = null;

    private B() {
    }

    public static B getInstance() {
        if (b == null) {
            synchronized (B.class) {
                if (b == null) {
                    b = new B();
                }
            }
        }
        return b;
    }
}

class C {
    private C() {
    }

    private static class SingleHolder {
        public static final C INSTANCE = new C();
    }

    public static C getInstance() {
        return SingleHolder.INSTANCE;
    }
}
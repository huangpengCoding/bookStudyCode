1)String 类是 final 型，固 String 类不能被继承，它的成员方法也都默认为 final 方法。String 对象一旦创建就固定不变了，对 String 对象的任何改变都不影响到原对象，相关的任何改变 操作都会生成新的 String 对象。

2)String 类是通过 char 数组来保存字符串的，String 对 equals 方法进行了重定，比较的是 值相等。

String a = "test"; String b = "test"; String c = new String("test");
a、b 和字面上的 test 都是指向 JVM 字符串常量池中的"test"对象，他们指向同一个对象。而 new 关键字一定会产生一个对象 test，该对象存储在堆中。所以 new String("test")产生了两 个对象，保存在栈中的 c 和保存在堆中的 test。而在 java 中根本就不存在两个完全一模一样 的字符串对象，故在堆中的 test 应该是引用字符串常量池中的 test。

例:

String str1 = "abc"; //栈中开辟一块空间存放引用 str1，str1 指向池中 String 常量"abc"

String str2 = "def"; //栈中开辟一块空间存放引用 str2，str2 指向池中 String 常量"def"

String str3 = str1 + str2;//栈中开辟一块空间存放引用 str3

//str1+str2 通过 StringBuilder 的最后一步 toString()方法返回一个新的 String 对象"abcdef" //会在堆中开辟一块空间存放此对象，引用 str3 指向堆中的(str1+str2)所返回的新 String 对象。 System.out.println(str3 == "abcdef");//返回 false

因为 str3 指向堆中的"abcdef"对象，而"abcdef"是字符池中的对象，所以结果为 false。JVM 对 String str="abc"对象放在常量池是在编译时做的，而 String str3=str1+str2 是在运行时才知 道的，new 对象也是在运行时才做的。
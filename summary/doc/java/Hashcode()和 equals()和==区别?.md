

#回答
> 1. hashcode()方法跟 equals()在 java 中都是判断两个对象是否相等
> 2. 两个对象相同，则 hashcode 至一定要相同，即对象相同 ---->成员变量相同
---->hashcode 值一定相同
> 3. 两个对象的hashcode值相同，对象不一定相等。总结:equals相等则hashcode一
定相等，hashcode 相等，equals 不一定相等。
> 4. ==比较的是两个引用在内存中指向的是不是同一对象(即同一内存空间)
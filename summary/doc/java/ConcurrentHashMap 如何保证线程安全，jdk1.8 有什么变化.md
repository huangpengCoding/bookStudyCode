

# 问题：ConcurrentHashMap 如何保证线程安全，jdk1.8 有什么变化？

> 1. JDK1.7：使用了分段锁机制实现 ConcurrentHashMap，ConcurrentHashMap 在对象中保存了一个 Segment 数组，即将整个 Hash 表划分为多个分段； 而每个 Segment 元素，即每个分段则类似于一个 Hashtable；这样，在执行 put 操作时 首先根据 hash 算法定位到元素属于哪个 Segment，然后对该 Segment 加锁即可。因此，ConcurrentHashMap 在多线程并发编程中可是实现多线程 put 操作，不过其最大并发度受 Segment 的个数限制。 
> 2. JDK1.8： 底层采用数组+链表+红黑树的方式实现，而加锁则采用 CAS 和 synchronized 实现参考文章：https://blog.csdn.net/weixin_44460333/article/details/86770169
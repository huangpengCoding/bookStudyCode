#URL
https://blog.csdn.net/ludx212/article/details/17281729


# 回答1
1.8 之后 hashMap 的数据结构发生了变化，从之前的单纯的数组+链表结构变成数组+链 表+红黑树。也就是说在 JVM 存储 hashMap 的 K-V 时仅仅通过 key 来决定每一个 entry 的存 储槽位(Node[]中的 index)。并且 Value 以链表的形式挂在到对应槽位上(1.8 以后如果 value 长度大于 8 则转为红黑树)。
但是 hashmap1.7 跟 1.8 中都没有任何同步操作，容易出现并发问题，甚至出现死循环 导致系统不可用。解决方案是 jdk 的 ConcurrentHashMap，位于 java.util.concurrent 下，专门 解决并发问题。

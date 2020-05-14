
##URL 
http://www.cnblogs.com/lzrabbit/p/3721067.html#h1

#回答
####HashMap与HashTable区别
1. 两者最主要的区别在于Hashtable是线程安全，而HashMap则非线程安全
2. HashMap可以使用null作为key，而Hashtable则不允许null作为key
3. HashMap是对Map接口的实现，HashTable实现了Map接口和Dictionary抽象类
4. HashMap的初始容量为16，Hashtable初始容量为11，两者的填充因子默认都是0.75
   HashMap扩容时是当前容量翻倍即:capacity*2，Hashtable扩容时是容量翻倍+1即:capacity*2+1
5. 两者计算hash的方法不同<br>
   Hashtable计算hash是直接使用key的hashcode对table数组的长度直接进行取模<br>
   HashMap计算hash对key的hashcode进行了二次hash，以获得更好的散列值，然后对table数组长度取摸
6. HashMap和Hashtable的底层实现都是数组+链表结构实现

####HashSet和HashMap、Hashtable的区别
1. 除开HashMap和Hashtable外，还有一个hash集合HashSet，有所区别的是HashSet不是key value结构，仅仅是存储不重复的元素，相当于简化版的HashMap，只是包含HashMap中的key而已 <br>
   通过查看源码也证实了这一点，HashSet内部就是使用HashMap实现，只不过HashSet里面的HashMap所有的value都是同一个Object而已，因此HashSet也是非线程安全的，至于HashSet和Hashtable的区别，HashSet就是个简化的HashMap的
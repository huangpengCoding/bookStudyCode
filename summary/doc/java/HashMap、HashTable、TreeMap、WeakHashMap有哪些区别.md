
## 回答
  #### HashMap HashTable
  * HashMap允许Key值为null 而HashTable不允许
  * HashMap把HashTable的contains方法去掉了，改成containsValue和containsKey方法
  * HashTable是线程安全的 而HashMap不是
  * HashTable使用Enumeration,HashMap使用Iterator
  * HashTable默认数组大小是11，增加的方式是old*2+1. 而HashMap中，hash数组的默认大小是16，而且一定是2的指数
  * Hash值使用不同 HashMap是计算key的hashcode 而HashTable是直接计算对象的Hashcode
  
  #### TreeMap
  TreeMao实现了SortMap接口，能够把它保存的记录根据键排序
  
  #### WeakHashMap
  key采用的是"弱引用"方式
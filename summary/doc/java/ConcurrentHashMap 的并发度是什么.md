

问题：ConcurrentHashMap 的并发度是什么

> 1. ConcurrentHashMap 的并发度就是 segment 的大小，默认为 16，这意味着最多同时可以有 16 条线程操作 ConcurrentHashMap，这也是 ConcurrentHashMap 对 Hashtable 的最大优 势，任何情况下，Hashtable 能同时有两条线程获取 Hashtable 中的数据吗？
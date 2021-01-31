#URL
https://www.cnblogs.com/kongcong/p/7777092.html
https://blog.csdn.net/leying521/article/details/93178185


###定义
 数据倾斜主要表现在，map/reduce程序执行时，reduce节点大部分执行完毕，但是有一个或者几个reduce节点运行很慢，导致整个程序的处理时间很长，这是因为某一个key的条数比其他key多很多(有时是百倍或者千倍之多)，这条Key所在的reduce节点所处理的数据量比其他节点就大很多，从而导致某几个节点迟迟运行不完。
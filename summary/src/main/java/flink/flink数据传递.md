

#回答

分三种情况讨论

1、本地线程内的数据传递 也就是同一个taskmanager里的一个slot 
既然在同一个slot里便是算子间组成了operatorchain
上游算子处理数据，然后通过collector接口直接调用下游算子的processElememnt(),
是在同一个线程内执行的普通java方法，没有将数据序列化写入共享内存、下游读取
数据再反序列化的过程，线程切换的开销也省掉了

2.本地线程间的数据传递
同一个taskmanager的不同task的算子之间，不是通过直接调用方法传输数据，而是
通过本地内存进行数据传递。
两个task线程共享还同一个bufferpool,通过wait()/notifyAll()来同步

3.跨网络的数据传递
也就是在不同taskmanager jvm中的task之间的数据传递。与2不同点在于，在没有buff
消费时，会发起rpc请求，读取buffer
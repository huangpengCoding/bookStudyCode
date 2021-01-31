
#URL
https://blog.csdn.net/qq_42596142/article/details/104455258
https://zhuanlan.zhihu.com/p/266620519
https://www.cnblogs.com/tuowang/p/9022198.html

回答：
 1.主要靠异步快照机制（checkpoint)和两阶段提交来实现的
 
 2.checkpoint策略是：flink会持续间隔一段时间对整个作业系统做snapshot(从jobmanager下发barrier到最后sink算子完成后返回确认给jobmanager)，
 会把各个算子global state存储在master node或者hdfs/rocksdb
 barrier从source出下发，依次到达下游算子时，会进行对齐后再继续往下游发送数据，这个对齐的过程是把先到barrier的数据，存储在input buffer中，
 等同一批的barrier都到了这个算子时，从input buffer中拿数据继续往下游发送，这个过程，一直到sink算子，
 确认完成后通知jobmanager，完成此次的checkpoint过程.
 
 3.两阶段提交主要是用的封装的`TwoPhaseCommitSinkFunction`
 需要实现其中的beginTransaction、preCommit、commit、abort 四个方法就可以实现“精确一次”的处理语义。
 beginTransaction，在开启事务之前，创建一个临时文件夹，然后把数据写入这个文件夹里面
 preCommit，在预提交阶段，将内存中缓存的数据写入文件并关闭；
 commit，在提交阶段，将预提交写入的临时文件放入目标目录下，这代表着最终的数据会有一些延迟；
 abort，在中止阶段，我们删除临时文件。
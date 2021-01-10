#URL
https://blog.csdn.net/huonan_123/article/details/104414396

#回答
1.随机分区器 ShufflePartitioner
根据均匀分布对元素进行随机划分

2.自定义分区器CustomPartitionerWrappery
  使用用户定义的分区程序为每个元素选择目标任务。
  
3.全局分区器GlobalPartitioner
该分区器会将所有的数据都发送到下游的某个算子实例(subtask id = 0)

4.重行分区 RebalancePartitioner
  分区元素轮循，从而为每个分区创建相等的负载。在存在数据偏斜的情况下对性能优化有用。
  
5.BroadcastPartitioner
发送到下游所有的算子实例


6.RescalePartitioner
基于上下游Operator的并行度，将记录以循环的方式输出到下游Operator的每个实例


7.ForwardPartitioner
发送到下游对应的第一个task，保证上下游算子并行度一致，即上有算子与下游算子是1:1的关系
对于ForwardPartitioner，必须保证上下游算子并行度一致，否则会抛出异常

8.KeyGroupStreamPartitioner
根据key的分组索引选择发送到相对应的下游subtask
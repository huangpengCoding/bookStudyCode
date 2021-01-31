
#URL
https://blog.csdn.net/jiang7chengzi/article/details/107545813
https://blog.csdn.net/leileibest_437147623/article/details/102773556


#anwser
1. StreamGraph
在client端

2.JobGraph
在client端 operator-chain优化

为了更高效地分布式执行，Flink会尽可能地将operator的subtask链接（chain）在一起形成task。
每个task在一个线程中执行。将operators链接成task是非常有效的优化：
    它能减少线程之间的切换，
    减少消息的序列化/反序列化
    减少数据在缓冲区的交换
    减少了延迟的同时提高整体的吞吐量。


3.ExecutionGraph
按并行度展开，分配到节点执行图

4.物理执行图
真正的物理节点上的执行图
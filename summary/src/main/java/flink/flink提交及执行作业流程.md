
#URL
https://blog.csdn.net/baichoufei90/article/details/108274922


#回答
Flink DataStream一个作业提交，大致有以下几步

1.编译阶段-Client生成StreamGraph
  
  将每个算子转换为Transformation，并且记录下每个input Transformation。
  将每个Transformation转换为StreamNode，以及带有并行度和Partitioner信息的、有向的StreamEdge，StreamNode会记录出边outEdges和入边inEdges
  这样就得到了一个有向图StreamGraph
  
2.编译阶段-Client通过StreamGraph生成JobGraph

    将无shuffle的node合并，如上图的Keyed Aggregation和Sink。
    为每个输出生成IntermediateDataset
    将StreamEdge转为JobEdge
    
3.运行阶段-将JobGraph提交到集群的JobManager，生成和调度 ExecutionGraph
    JM将客户端提交过来的JobGraph ，将任务按并行度拆分为subtask、IntermediateDataset拆分为IntermediateResultPartition，
    按Edge上的partitioner信息拆分为ExecutionEdge， 最终得到ExecutionGraph
    
4.运行阶段-JM将ExecutionGraph概念化得到一张运行图（虚拟图）
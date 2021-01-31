
#URL
https://blog.csdn.net/lb812913059/article/details/89501058

#回答

自下而上

1.Deploy 
该层主要涉及了Flink的部署模式，Flink支持多种部署模式：本地、集群（Standalone/YARN）、云（GCE/EC2）

2.Core(Runtime)

Runtime层提供了支持Flink计算的全部核心实现，比如支持分布式Stream处理、JobGraph到ExecutionGraph的映射、调度等等，为上层API层提供基础服务。

3.API
API层主要实现了面向无界Stream的流处理和面向Batch的批处理API，其中面向流处理对应DataStream API，面向批处理对应DataSet API。

4.Libraries
Libraries层也可以称为Flink应用框架层，根据API层的划分，在API层之上构建的满足特定应用的实现计算框架，也分别对应于面向流处理和面向批处理两类。

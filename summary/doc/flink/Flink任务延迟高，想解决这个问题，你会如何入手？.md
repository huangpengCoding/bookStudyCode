

#回答

在Flink的后台任务管理中，我们可以看到Flink的哪个算子和task出现了反压。
最主要的手段是资源调优和算子调优。资源调优即是对作业中的Operator的并发数
（parallelism）、CPU（core）、堆内存（heap_memory）等参数进行调优。作业参数调优包括：并行度的设置，State的设置，checkpoint的设置。
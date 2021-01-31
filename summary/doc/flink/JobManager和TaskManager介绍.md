
#URL
https://blog.csdn.net/weidaoyouwen/article/details/87194958
https://blog.csdn.net/qq_39657909/article/details/105823127



#回答

Flink程序需要提交给Job Client。 然后，Job Client将作业提交给Job Manager。 
Job Manager负责协调资源分配和作业执行。 它首先要做的是分配所需的资源。 资源分配完成后，任务将提交给相应的Task Manager。 在接收任务时，Task Manager启动一个线程以开始执行。 执行到位时，Task Manager会继续向Job Manager报告状态更改。 可以有各种状态，例如开始执行，正在进行或已完成。 作业执行完成后，结果将发送回客户端（Job Client）

[jobmanager]
1.调度执行和管理，将jobgraph->ExecutionGraph 调度task的执行 并处理task异常
2.作业slot资源的管理
3.检查点/保存点的故哪里，负责发起，完成去人，取消本次执行等
4.监控运维: 反压跟踪、作业状态作业算子的吞吐量等监控指标
5.心跳管理

[taskmanager]
1.负责执行任务的真正节点，每个taskmanager就是一个jvm进程

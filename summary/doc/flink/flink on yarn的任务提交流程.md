

https://blog.csdn.net/wwwzydcom/article/details/100547564



## note

1. 任务提交后,client向hdfs上传flink的jar包以及配置
2. 向Yarn的ResourceManager提交任务
3. ResourceManager分配Container资源并通知对应的NodeManager启动ApplicationMaster
4. ApplicationMaster启动后加载flink的jar包和构建环境,启动JobManager
5. applicationMaster向ResourceManager申请资源启动taskManager
6. nodemanager加载flink的jar包和配置环境启动TaskManager
7. taskManager发送心跳包,等待JobManager向其分配任务

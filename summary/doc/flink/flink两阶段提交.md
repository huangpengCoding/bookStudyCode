#URL
https://blog.csdn.net/lisenyeahyeah/article/details/90288231


#回答
以kafka为例，0.11版本后引入了幂等发送和事务，从而保证了端到端的exactly-once

### 幂等：
为了实现Producer的幂等语义，Kafka引入了Producer ID（即PID）和Sequence Number。每个新的Producer在初始化的时候会被分配一个唯一的PID，该PID对用户完全透明而不会暴露给用户。
Producer发送每条消息<Topic, Partition>对于Sequence Number会从0开始单调递增，broker端会为每个<PID, Topic, Partition>维护一个序号，每次commit一条消息此序号加一，对于接收的每条消息，如果其序号比Broker维护的序号（即最后一次Commit的消息的序号）大1以上，则Broker会接受它，否则将其丢弃：
序号比Broker维护的序号大1以上，说明存在乱序。
序号比Broker维护的序号小，说明此消息以及被保存，为重复数据。


### 事务
两阶段提交 = 预提交+实际提交
TwoPhaseCommitSinkFunction
两阶段的完整流程，提交过程中如果失败有以下两种情况
Pre-commit失败，将恢复到最近一次CheckPoint位置
一旦pre-commit完成，必须要确保commit也要成功



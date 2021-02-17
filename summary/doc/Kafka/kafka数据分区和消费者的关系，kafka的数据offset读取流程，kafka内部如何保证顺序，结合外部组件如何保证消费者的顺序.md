


问题：kafka数据分区和消费者的关系，kafka的数据offset读取流程，kafka内部如何保证顺序，结合外部组件如何保证消费者的顺序

1. kafka数据分区和消费者的关系：1个partition只能被同组的⼀个consumer消费，同组的consumer则起到均衡效果
2. kafka的数据offset读取流程
​ [1] 连接ZK集群，从ZK中拿到对应topic的partition信息和partition的Leader的相关信息<br>
​ [2] 连接到对应Leader对应的broker<br>
​ [3] consumer将⾃⼰保存的offset发送给Leader<br>
​ [4] Leader根据offset等信息定位到segment（索引⽂件和⽇志⽂件）<br>
​ [5] 根据索引⽂件中的内容，定位到⽇志⽂件中该偏移量对应的开始位置读取相应⻓度的数据并返回给consumer
3. kafka内部如何保证顺序：
kafka只能保证partition内是有序的，但是partition间的有序是没办法的。爱奇艺的搜索架构，是从业务上把需要有序的打到同⼀
个partition。
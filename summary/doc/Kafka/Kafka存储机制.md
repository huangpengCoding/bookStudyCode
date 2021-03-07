#URL
https://blog.csdn.net/zhangxm_qz/article/details/87636094


#回答
  kafka 使用日志文件的方式来保存生产者和发送者的消息，每条消息都有一个 offset 值来表示它在分区中的偏移量。Kafka 中存储的一般都是海量的消息数据，为了避免日志文件过大，一个分片 并不是直接对应在一个磁盘上的日志文件，而是对应磁盘上的一个目录，这个目录的命名规则是<topic_name>_<partition_id>。
比如创建一个名为firstTopic的topic，其中有3个partition，那么在 kafka 的数据目录（/tmp/kafka-log）中就有 3 个目录，firstTopic-0~3
多个分区在集群中多个broker上的分配方法
> 1. 将所有 N Broker 和待分配的 i 个 Partition 排序
> 2. 将第 i 个 Partition 分配到第(i mod n)个 Broker 上

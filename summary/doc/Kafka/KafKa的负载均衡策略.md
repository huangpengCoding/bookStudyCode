
https://blog.csdn.net/ajianyingxiaoqinghan/article/details/107192386


## 回答
分区器是生产者层面的负载均衡。Kafka 生产者生产消息时，根据分区器将消息投递到指定的分区中，所以 Kafka 的负载均衡很大程度上依赖于分区器。
Kafka 默认的分区器是 Kafka 提供的 DefaultPartitioner。它的分区策略是根据 Key 值进行分区分配的：

> 如果 key 不为 null：对 Key 值进行 Hash 计算，从所有分区中根据 Key 的 Hash 值计算出一个分区号；拥有相同 Key 值的消息被写入同一个分区；
> 如果 key 为 null：消息将以轮询的方式，在所有可用分区中分别写入消息。

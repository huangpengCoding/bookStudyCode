
#URL
https://blog.csdn.net/u010376788/article/details/92086752
https://blog.csdn.net/u010376788/article/details/95047250
https://www.cnblogs.com/xiexiandong/p/12756035.html

#回答
[反压原理]
1.flink1.5版本及之前 是基于tcp方式的
2.flink1.5版本后是基于信用的反压

Flink 没有使用任何复杂的机制来解决反压问题，Flink 在数据传输过程中使用了分布式阻塞队列。我们知道在一个阻塞队列中，
当队列满了以后发送者会被天然阻塞住，这种阻塞功能相当于给这个阻塞队列提供了反压的能力。

[如何定位]
1.通过 Flink Web UI 自带的反压监控面板；
2.通过 Flink Task Metrics。


[内部如何处理]
Flink 内部是基于 producer-consumer 模型来进行消息传递的，Flink的反压设计也是基于这个模型。
Flink 使用了高效有界的分布式阻塞队列，就像 Java 通用的阻塞队列（BlockingQueue）一样。
下游消费者消费变慢，上游就会受到阻塞。
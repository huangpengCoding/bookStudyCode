#URL
https://developer.aliyun.com/article/778209?spm=a2c6h.12873581.0.dArticle778209.46222634GPJElJ&groupCode=sc


#回答

[组成条件]
1.上下游的并行度一致
2.下游节点的入度为 1 （也就是说下游节点没有来自其他节点的输入）
3.上下游节点都在同一个 slot group 中(Slot槽位共享)
4.下游节点的 chain 策略为 ALWAYS（可以与上下游链接，map、flatmap、filter 等默认 是 ALWAYS）
5.上游节点的 chain 策略为 ALWAYS 或 HEAD（只能与下游链接，不能与上游链接， Source 默认是 HEAD）
6.两个节点间数据分区方式是 forward
7.用户没有禁用chain

[好处]
1.它能减少线程之间的切换
2.减少消息的序列化/反序列化
3.减少数据在缓冲区的交换
4.减少了延迟的同时提高整体的吞吐量
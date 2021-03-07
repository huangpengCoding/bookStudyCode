
## 回答

> 1. 节点必须可以维护和 ZooKeeper 的连接，Zookeeper 通过心跳机制检查每 
个节点的连接 
> 2. 如果节点是个 follower,他必须能及时的同步 leader 的写操作，延时不能太 
久 
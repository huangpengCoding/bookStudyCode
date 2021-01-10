
#URL
https://www.jianshu.com/p/ac0fff780d40?from=singlemessage

#回答
  flink提供不同的状态后端（state backends）来区分状态的存储方式和存储位置。flink状态可以存储在java堆内存内或者内存之外。通过状态后端的设置，flink允许应用保持大容量的状态。开发者可以在不改变应用逻辑的情况下设置状态后端。
  默认情况下，flink的状态会保存在taskmanager的内存中，而checkpoint会保存在jobManager的内存中。

flink提供三种开箱即用的State Backend：
MemoryStateBackend
FsStateBackend
RocksDBStateBackend

#URL
https://blog.csdn.net/a3125504x/article/details/108719316
https://blog.csdn.net/lzxlfly/article/details/108687266

#回答
[基本类型去分]

* OperatorState
    它是和Key无关的一种状态类型。相应地我们从逻辑上去理解这个概念，它相当于一个并行度实例，对应一份状态数据。因为这里没有涉及Key的概念，所以在并行度（扩/缩容）发生变化的时候，这里会有状态数据的重分布的处理。
    
    ValueState
    
* KeyState
    和Key有关的状态类型，它只能被基于KeyedStream之上的操作，方法所使用。我们可以从逻辑上理解这种状态是一个并行度操作实例和一种Key的对应
    
    ValueState
    ListState
    MapState
    ReducingState
    AggregatingState
    FoldingState
    
[组织形式划分]

* Managed State
    这类State的内部结构完全由Flink runtime内部来控制，包括如何将它们编码写入到checkpoint中等等。

* Raw State
    这类State就比较显得灵活一些，它们被保留在操作运行实例内部的数据结构中。从Flink系统角度来观察，在checkpoint时，它只知道的是这些状态数据是以连续字节的形式被写入checkpoint中。等待进行状态恢复时，又从字节数据反序列化为状态对象。
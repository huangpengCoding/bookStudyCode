

#分层模型
[SQL]

[Table Api]
 构建在Table 之上，都需要构建Table 环境 
不同的类型的Table 构建不同的Table 环境 
Table 可以与DataStream或者DataSet进行相互转换 
Streaming SQL不同于存储的SQL，最终会转化为流式执行计划 

[DataStream/DataSet Api]
DataSet - 批处理 API 
DataStream –流处理 API 
封装了一些算子

[Stateful Stream Processing]
位于最底层， 是core API 的底层实现 
processFunction （处理函数）
利用低阶，构建一些新的组件或者算子 
灵活性高，但开发比较复杂 
表达性最强，可以操作状态，time等
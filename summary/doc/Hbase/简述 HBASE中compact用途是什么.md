#回答
在hbase中每当有memstore数据flush到磁盘之后，就形成一个storefile，当storeFile的数量达到一定程度后，就需要将 storefile 文件来进行 compaction 操作。
###Compact 的作用：

 1. 合并文件
 2. 清除过期，多余版本的数据
 3. 提高读写数据的效率
<br>
HBase 中实现了两种 compaction 的方式：minor and major. 这两种 compaction 方式的区别是：
* 1、Minor 操作只用来做部分文件的合并操作以及包括 minVersion=0 并且设置 ttl 的过
期版本清理，不做任何删除数据、多版本数据的清理工作
* 2、Major 操作是对 Region 下的HStore下的所有StoreFile执行合并操作，最终的结果是整理合并出一个文件。

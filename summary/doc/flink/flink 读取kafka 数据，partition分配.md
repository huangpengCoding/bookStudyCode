
#URL
https://www.cnblogs.com/Springmoon-venn/p/10636486.html


#回答
flink 读取kafka 数据，partition分配
每个并发有个编号，只会读取kafka partition  % 总并发数 == 编号 的分区
 
如： 6 分区， 4个并发
分区： p0 p1 p2 p3 p4 p5
并发： 0 1 2 3 
 
分区 p0 分配给并发 0 ：    0 % 4 = 0
分区 p1分配给并发1：    1 % 4 = 1
分区 p2分配给并发2：    2 % 4 = 2
分区 p3 分配给并发 3：    3 % 4 = 3
分区 p4 分配给并发 0 ：    4 % 4 = 0
分区 p5 分配给并发 5 ：    5 % 4 = 1
#URL
https://blog.csdn.net/u010002184/article/details/106800819

#回答

1.join 
可以join2个类型不同的流或join2个类型不同的数据集（比如Tuple2<String, Long> join Tuple2<Long,String>）
,但是匹配的key或field类型要一致，不然报错（比如where中的String与equalTo中的String匹配才行）

2.cogroup
侧重于group 
与join基本相同 有一点不一样的是 如果未能join上 也会输出

3.connnect
类型可以不相同 只能2个流

4.union
类型必须相同 可以是多个流

5.intervaljoin

6.外存关联
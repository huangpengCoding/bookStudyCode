#URL
https://www.cnblogs.com/LHWorldBlog/p/8299363.html

#回答
1. 预分区 预先创建一些空的regions
2. rowkey设计 
   * rowkey是字典序的 将经常读的数据放在一块
   * 越小越好
   * 散列性
  
3. 列族的设计 不要在一张表里定义太多的column family。目前Hbase并不能很好的处理超过2~3个column family的表。因为某个column family在flush的时候，它邻近的column family也会因关联效应被触发flush，最终导致系统产生更多的I/O。感兴趣的同学可以对自己的HBase集群进行实际测试，从得到的测试结果数据验证一下。
4. In Memory
   * 创建表的时候，可以通过HColumnDescriptor.setInMemory(true)将表放到RegionServer的缓存中，保证在读取的时候被cache命中。（读缓存）
5. Max Version
   * 创建表的时候，可以通过HColumnDescriptor.setMaxVersions(int maxVersions)设置表中数据的最大版本，如果只需要保存最新版本的数据，那么可以设置setMaxVersions(1)。
6. Time To Live
   * 创建表的时候，可以通过HColumnDescriptor.setTimeToLive(int timeToLive)设置表中数据的存储生命期，过期数据将自动被删除，例如如果只需要存储最近两天的数据，那么可以设置setTimeToLive(2 * 24 * 60 * 60)。（相当于Linux中的Crontab任务）
7. Compact & Split
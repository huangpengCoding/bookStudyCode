#URL
https://www.cnblogs.com/y-rong/p/8110596.html

###Myisam
表级锁
不支持事务
属于堆表

###InnnoDB
行级锁
支持事务
属于索引组织表



##总结
1.MyISAM不支持事务，InnoDB是事务类型的存储引擎，当我们的表需要用到事务支持的时候，那肯定是不能选择MyISAM了
2.MyISAM只支持表级锁，BDB支持页级锁和表级锁默认为页级锁，而InnoDB支持行级锁和表级锁默认为行级锁
表级锁：直接锁定整张表，在锁定期间，其他进程无法对该表进行写操作，如果设置的是写锁，那么其他进程读也不允许
3.MyISAM引擎不支持外键，InnoDB支持外键
4.MyISAM引擎的表在大量高并发的读写下会经常出现表损坏的情况
5.对于count()查询来说MyISAM更有优势
6. InnoDB是为处理巨大数据量时的最大性能设计，它的CPU效率可能是任何其它基于磁盘的关系数据库引擎所不能匹敌的。
7.MyISAM支持全文索引（FULLTEXT），InnoDB在v5.6.4才初步支持
8.MyISAM引擎的表的查询、更新、插入的效率要比InnoDB高


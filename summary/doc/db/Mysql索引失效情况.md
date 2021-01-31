## URL
  https://www.jianshu.com/p/9c9a0057221f
## 回答
    * where查询条件带有!= 或者 is not 或>、<、>=等这样的运算
    * 如果再索引列上使用的函数
    * 如果使用的是多列索引，必须满足最左前缀法，不是使用第一部分，则无法使用索引
    * like查询以%开头
    * 如果列类型是字符串，那一定要在条件中数据使用引号，否则不使用索引
    * 有or连接的情况 
    
    
(1) 索引的作用:在数据库表中对字段建立索引可以大大提高查询速度。

(2) Mysql 索引类型:

a) 普通索引

b) 唯一索引:唯一索引列的值必须唯一允许有空值，如果是组合索
            引，则列值的组合必须唯一:
CREATE UNIQUE INDEX indexName ON mytable(username(length)) -- 修改表结构
ALTER mytable ADD UNIQUE [indexName] ON (username(length)) -- 创建表的时候直接指定
CREATE TABLE mytable( ID INT NOT NULL, username VARCHAR(16)
NOT NULL, UNIQUE [indexName] (username(length)) );

c) 主键索引:一种特殊的唯一索引，不允许有空值，一般在创建表
的时候创建主键索引:
CREATE TABLE mytable( ID INT NOT NULL,
VARCHAR(16) NOT NULL, PRIMARY KEY(ID) );

d) 组合索引:CREATE TABLE mytable( ID INT NOT NULL,
VARCHAR(16) NOT NULL, city VARCHAR(50) NOT NULL,
NOT NULL );
为了进一步榨取 MySQL 的效率，就要考虑建立组合索引。就是 将 name, city, age 建到一个索引里:代码如下:
ALTER TABLE mytable ADD INDEX name_city_age
(name(10),city,age);

(3) 什么情况下有索引，但用不上?

a) 如果条件中有 OR，即使其中有部分条件带索引也不会使用。注 意:要想使用 or，又想让索引生效，只能将 or 条件中的每个列 都加上索引。

b) 对于多了索引，不是使用的第一部分，则不会使用索引。

c) Like 查询以%开头，不使用索引

d) 存在索引列的数据类型隐形转换，则用不上索引，比如列类型是
字符串，那一定要在条件中将数据使用引号引用起来,否则不使
用索引

e) Where 子句里对索引列上有数学运算，用不上索引

f) Where 子句中对索引列使用函数，用不上索引

g) Mysql 估计使用全表扫描要比用索引快，不使用索引

(4) 什么情况下不推荐使用索引?

a) 数据唯一性差的字段不要使用索引

b) 频繁更新的字段不要使用索引

c) 字段不在 where 语句中出现时不要添加索引，如果 where 后含
IS NULL/IS NOT NULL/LIKE ‘%输入符%’等条件，不要使用索引

d) Where 子句里对索引使用不等于(<>)，不建议使用索引，效果
username
username age INT
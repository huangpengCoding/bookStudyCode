#URL
https://www.jianshu.com/p/cea1f9619e8f

#回答

#### CAS
  但是cas也有缺点
  * ABA问题 不一定期间就没有别的变量对其进行了修改 解决办法:Java提供了AtomicStampedReference 通过为引用类建立类似版本号来保证CAS正确性
  * 循环时间开销过大 CAS使用失败重试机制 会产生自旋 消耗CPU 
  * 只能保证一个共享变量的原子操作
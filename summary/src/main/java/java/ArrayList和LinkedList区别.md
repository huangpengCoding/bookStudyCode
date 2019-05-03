
## 回答

  1. ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。 
  2. 对于随机访问get和set，ArrayList觉得优于LinkedList，因为LinkedList要移动指针。 
  3. 对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。 
  
## 补充
  * ArrayList和Vector都是基于存储元素的Object[] array来实现的 它支持用序号来访问元素 所以get很快 但是set时 需要移动元素就效率慢了  
  * Vector是线程安全的
  * LinkedList是采用双向链表来实现的,对数据的索引需要从列表头开始遍历,因此用于随机访问则效率低，但是插入元素时不需要对数据进行移动，因此插入效率高

## URL
 https://cloud.tencent.com/developer/article/1388383
 https://www.jianshu.com/p/108ddab3ad3f
 

## 回答
   * 引用计数法：给对象添加一个引用计数器，当有一个地方引用它，计数器加1；当引用失效，计数器减1.任何时刻计数器为0，表示这个对象可以被回收
   * 可达性分析算法：通过一系列称为 "GC Roots" 的对象作为起始点，从这个节点向下搜索，搜索走过的路径就是引用链，当一个对象到 GC Roots 没有任何引用链相连，也就是从 GC Roots 到这个对象不可达，则这个对象不可达，可以被回收。
   
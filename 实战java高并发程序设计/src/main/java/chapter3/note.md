## 第3章 JDK并发包

### 重入锁
 * 重入锁可以完全替代synchronized 早期重入锁性能优于synchronized 现在性能差不多
 * 重入锁需要手动指定加锁释放锁，灵活性有保证
 * 重入锁是可以反复进入的
 * 重入锁可以被中断，用lockInterruptibly()
 * tryLock()进行一次显示的等待 可以带时间参数 也可以不带
 * 大多数情况下，锁的申请是非公平的.重入锁可以进行公平锁设置：new ReentrantLock(true)  <br>
 公平锁会降低性能，没必要的话不需要设置
 * ReentrantLock几个重要的用法:<br>
     &nbsp;&nbsp;&nbsp;&nbsp;lock() 获得锁，如果锁已经被占用，则等待<br>
     &nbsp;&nbsp;&nbsp;&nbsp;lockInterruptibly() 获得锁，但优先响应中断<br>
     &nbsp;&nbsp;&nbsp;&nbsp;tryLock() 尝试获得锁,如果成功，则返回true,失败返回false.该方法不等待，立即返回<br>
     &nbsp;&nbsp;&nbsp;&nbsp;tryLock(long time, TimeUnit unit) 在给定时间内尝试获得锁<br>
     &nbsp;&nbsp;&nbsp;&nbsp;unlock() 释放锁<br>
 * 重入锁的实现原理<br>
 &nbsp;&nbsp;&nbsp;&nbsp;第一，原子状态。原子状态使用CAS操作,来存储当前锁的状态,判断锁是否已经被别的线程持有了.<br>
 &nbsp;&nbsp;&nbsp;&nbsp;第二，等待队列。所有没有请求到锁的线程，会进入等待队列进行等待。待有线程释放锁后，系统就能从等待队列中唤醒一个线程，继续工作.<br>
 &nbsp;&nbsp;&nbsp;&nbsp;第三，阻塞原语park()和unpark()，用来挂起和恢复线程。没有得到锁的线程将会被挂起。<br>
 * 重入锁的好搭档:Condition<br>
     &nbsp;&nbsp;&nbsp;&nbsp;await()方法会使当前线程等待，同时释放当前锁，当其他线程中使用signal()或signalAll()时,线程会重新获得锁并继续执行.或者当线程被中断时，也能跳出等待.这和Object.wait()方法相似.<br>
     &nbsp;&nbsp;&nbsp;&nbsp;awaitUninterruptibly()与await()方法基本相同，但是它并不会在等待的过程中响应中断.<br>
     &nbsp;&nbsp;&nbsp;&nbsp;singal()方法用于唤醒一个在等待中的线程，singalAll()方法会唤醒所有在等待中的线程。这和Object.notify()方法很类似
     
### 重入锁
 * 信号量为多线程协作提供了更为强大的控制方法。从广义上说，信号量是对锁的扩展。无论是内部锁synchronized还是重入锁ReentrantLock,一次都允许线程访问一个资源,而信号量却可以指定多个线程，同时访问某一个资源.
 
### ReadWriteLock
 * 就只有 读-读 不互斥
  
### 线程池 Excutor包
 * 常用的线程池工厂方法:<br>
   &nbsp;&nbsp;&nbsp;&nbsp; newFixedThreadPool() <br>
   &nbsp;&nbsp;&nbsp;&nbsp; newSingleThreadExecutor() <br>
   &nbsp;&nbsp;&nbsp;&nbsp; newCachedThreadPool() <br>
   &nbsp;&nbsp;&nbsp;&nbsp; newSingleThreadScheduledExecutor() <br>
   &nbsp;&nbsp;&nbsp;&nbsp; newScheduledThreadPool() <br>        
   
 
  
  
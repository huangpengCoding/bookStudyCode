

问题：什么是AQS

> 1. AQS 是 AbustactQueuedSynchronizer 的简称，它是一个 Java 提高的底层同步工具类，用一 个 int 类型的变量表示同步状态，并提供了一系列的 CAS 操作来管理这个同步状态。 
> 2. AQS 是一个用来构建锁和同步器的框架，使用 AQS 能简单且高效地构造出应用广泛的大量 的同步器，比如我们提到的 ReentrantLock，Semaphore，其他的诸如 ReentrantReadWriteLock， SynchronousQueue，FutureTask 等等皆是基于 AQS 的。


问题：AQS 支持两种同步方式

（1）独占式 
（2）共享式 

> 这样方便使用者实现不同类型的同步组件，独占式如 ReentrantLock，共享式如 Semaphore， CountDownLatch，组 合 式 的 如 ReentrantReadWriteLock。总之，AQS 为使用提供了底层 支撑，如何组装实现，使用者可以自由发挥。
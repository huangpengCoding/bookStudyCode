

问题：ReadWriteLock 是什么

> 1. 首先明确一下，不是说 ReentrantLock 不好，只是 ReentrantLock 某些时候有局限。如果使 用 ReentrantLock，可能本身是为了防止线程 A 在写数据、线程 B 在读数据造成的数据不 一致，但这样，如果线程 C 在读数据、线程 D 也在读数据，读数据是不会改变数据的， 没有必要加锁，但是还是加锁了，降低了程序的性能。因为这个，才诞生了读写锁 ReadWriteLock 。 ReadWriteLock 是 一 个 读 写 锁 接 口 ， ReentrantReadWriteLock 是 ReadWriteLock 接口的一个具体实现，实现了读写的分离，读锁是共享的，写锁是独占的， 读和读之间不会互斥，读和写、写和读、写和写之间才会互斥，提升了读写的性能。
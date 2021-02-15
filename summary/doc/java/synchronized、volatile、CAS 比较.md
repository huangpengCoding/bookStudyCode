

问题：synchronized、volatile、CAS 比较


> 1. synchronized 是悲观锁，属于抢占式，会引起其他线程阻塞。
> 2. volatile 提供多线程共享变量可见性和禁止指令重排序优化。
> 3. CAS 是基于冲突检测的乐观锁（非阻塞）
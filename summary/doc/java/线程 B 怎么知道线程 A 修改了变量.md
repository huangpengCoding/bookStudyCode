

问题：线程 B 怎么知道线程 A 修改了变量


> 1. volatile 修饰变量 
> 2. synchronized 修饰修改变量的方法 
> 3. wait/notify 
> 4. while 轮询
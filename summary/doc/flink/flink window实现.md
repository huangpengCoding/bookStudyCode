

#URL
https://www.jianshu.com/p/442e18ff56f3


#回答

主要是三个组件
* Window Assigner：用来决定某个元素被分配到哪个/哪些窗口中去
* Trigger：触发器。决定了一个窗口何时能够被计算或清除，每个窗口都会拥有一个自己的Trigger
* Evictor：可以译为“驱逐者”。在Trigger触发之后，在窗口被处理之前，Evictor（如果有Evictor的话）会用来剔除窗口中不需要的元素，相当于一个filter



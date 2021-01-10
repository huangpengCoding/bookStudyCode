#URL
https://www.jianshu.com/p/2e87abfe89ff



#回答

我们知道，流处理从事件产生，到流经source，再到operator，中间是有一个过程和时间的。
虽然大部分情况下，流到operator的数据都是按照事件产生的时间顺序来的，但是也不排除由于网络延迟等原因，导致乱序的产生，
特别是使用kafka的话，多个分区的数据无法保证有序。所以在进行window计算的时候，我们又不能无限期的等下去，必须要有个机制来保证一个特定的时间后，
必须触发window去进行计算了。这个特别的机制，就是watermark，watermark是用于处理乱序事件的。


触发条件：
    1. watermark > window_end_time
    2. window内有数据
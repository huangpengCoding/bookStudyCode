

问题：java 中==和 equals 和 hashCode 的区别？

> 1. ==若是基本数据类型比较，是比较值，若是引用类型，则比较的是他们在内存中的存 放地址。对象是存放在堆中，栈中存放的对象的引用，所以==是对栈中的值进行比较，若 返回 true 代表变量的内存地址相等； 
> 2. equals 是 Object 类中的方法，Object 类的 equals 方法用于判断对象的内存地址引用 是不是同一个地址（是不是同一个对象）。若是类中覆盖了 equals 方法，就要根据具体代 码来确定，一般覆盖后都是通过对象的内容是否相等来判断对象是否相等。 
> 3. hashCode()计算出对象实例的哈希码，在对象进行散列时作为 key 存入。之所以有 hashCode 方法，因为在批量的对象比较中，hashCode 比较要比 equals 快。在添加新元 素时，先调用这个元素的 hashCode 方法，一下子能定位到它应该旋转的物理位置，若该 位置没有元素，可直接存储；若该位置有元素，就调用它的 equals 方法与新元素进行比较， 若相同则不存，不相同，就放到该位置的链表末端。 
> 4. equals 与 hashCode 方法关系： hashCode()是一个本地方法，实现是根据本地机器上关的。equals()相等的对象， hashCode()也一定相等；hashCode()不等，equals()一定也不等；hashCode()相等，equals() 可能相等，也可能不等。 所 以 在 重 写 equals(Object obj) 方 法 ， 有 必 要 重 写 hashCode() 方 法 ， 确 保 通 过
equals(Object obj)方法判断结果为 true 的两个对象具备相等的 hashCode()返回值。 
> 5. equals 与==的关系： Integer b1 = 127;在 java 编译时被编译成 Integer b1 = Integer.valueOf(127);对于-128 到 127 之间的 Integer 值，用的是原生数据类型 int，会在内存里供重用，也就是这之间的 Integer 值进行==比较时，只是进行 int 原生数据类型的数值进行比较。而超出-128〜127 的范围，进行==比较时是进行地址及数值比较。
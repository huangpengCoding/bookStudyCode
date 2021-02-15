在运行状态中，对任意一个类，都能知道这个类的所有属性和方法，对任意一个对象，都能 调用它的任意一个方法和属性。这种能动态获取信息及动态调用对象方法的功能称为 java 语言的反射机制。
反射的作用:开发过程中，经常会遇到某个类的某个成员变量、方法或属性是私有的，或只 对系统应用开放，这里就可以利用 java 的反射机制通过反射来获取所需的私有成员或是方 法。
1) 获取类的 Class 对象实例 Class clz = Class.forName("com.zhenai.api.Apple");

2) 根 据 Class 对 象 实 例 获 取 Constructor 对 象 Constructor appConstructor = clz.getConstructor();

3) 使用 Constructor 对象的 newInstance 方法获取反射类对象 Object appleObj = appConstructor.newInstance();

4) 获取方法的 Method 对象 Method setPriceMethod = clz.getMethod("setPrice", int.class);

5) 利用 invoke 方法调用方法 setPriceMethod.invoke(appleObj, 14);

6) 通过 getFields()可以获取 Class 类的属性，但无法获取私有属性，而 getDeclaredFields()可 以获取到包括私有属性在内的所有属性。带有 Declared 修饰的方法可以反射到私有的方法， 没有 Declared 修饰的只能用来反射公有的方法，其他如 Annotation\Field\Constructor 也是如 此。

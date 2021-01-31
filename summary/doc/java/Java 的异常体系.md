

Java 中 Throwable 是所有异常和错误的超类，两个直接子类是 Error(错误)和 Exception(异 常):
1)Error 是程序无法处理的错误，由 JVM 产生和抛出，如 OOM、ThreadDeath 等。这些异常 发生时，JVM 一般会选择终止程序。
2 )E x c e p t i o n 是 程 序 本 身 可 以 处 理 的 异 常 ，又 分 为 运 行 时 异 常 ( R u n t i m e E x c e p t i o n ) ( 也 叫 C h e c k e d Eception)和非运行时异常(不检查异常 Unchecked Exception)。运行时异常有 NullPointerException\IndexOutOfBoundsException 等，这些异常一般是由程序逻辑错误引起 的，应尽可能避免。非运行时异常有 IOException\SQLException\FileNotFoundException 以及 由用户自定义的 Exception 异常等。

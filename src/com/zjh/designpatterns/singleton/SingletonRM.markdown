>遇到了一个IDEA问题，在Preferences-Editor-fileType中的markdown类型下，
>添加`*.md`类型，确定，此时所有的md类型的文件都被识别成markdown文档，
>但是重启IDEA，再去fileType的markdown类型下看，`*.md`已经没有了，只有`*.markdown`怪哉

# Singleton 单例模式

# 代码分析
## old
> 出现问题从properties配置文件中读取的中文乱码。虽然右下角显示的是utf-8，但实际上不是。解决：Preferences->Editor->File Encoding->勾选透明到原声的ASCII转换；此时，再次读取还是不行，重新删除properties配置文件，新建，重新输入，解决了。
- AppConfig类：从文件中读取配置信息

存在问题：许多地方都需要使用配置文件的内容==在很多地方会创建很多AppConfig实例==同时在内存中存在多份相同的配置文件内容，浪费内存

## model
- LazySingleton类：懒汉式，需要的时候才创建
- HungrySingleton类：饿汉式，在类加载的时候创建

存在问题：LazySingleton中getInstance方法加上synchronized的方法，每次都要判断，会将整个访问的速度

## concrete
> 一个项目中不能有两个properties文件，即使是在不同的文件夹下也不行

将AppConfig根据model中的单例模型改为单例实现即可

## advanced 双重检查加锁
用volatile将自己类型的静态成员变量放到多线程共享内存区，先判断是否为null，如果是，进入sycronized再判断是否为null（防止两个线程同时获取了sycronized，一个在外面等待，另一个进去修改的情况）

解决了model中的问题：好处：既能实现线程安全，又能使性能不受到影响，即只有在第一次创建的的情况下才会执行同步代码块，以后就不需要同步了，加快了运行速度。

存在问题：
volatile关键字：被volatile修饰的变量的值，将不会被本地线程缓存，所有对该变量的操作都是操作共享内存，从而确保多个线程能正常处理该变量。   
volatile会屏蔽掉虚拟机中一些必要的代码优化，所以运行效率并不是很高，没有特别需要不建议使用，这个单例方法也不建议大量使用

## advanced2 Lazy initialization holder class（建议大量使用）
使用静态内部类，在调用getInstance方法的时候初始化这个静态内部类，让这个内部类去创建它外面这类的实例。

问题引入：饿汉式在类装载的时候就初始化对象，不管你需不需要，那能不能在类装载的时候不去初始化对象呢

原理：利用类只会被装载一次，静态域只会在虚拟机装载类的时候才会初始化，因此可以由虚拟机来保证它的线程安全

## advanced3 枚举
《高效Java 第二版》中说：单元素的枚举类已经成为实现Singleton的最佳方法

特点：简洁，只有一行代码，高效，无偿提供序列化机制，安全，又JVM从根本上保证了不会多次实例化

# 优缺点
优缺点：空间换时间

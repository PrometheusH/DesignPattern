# Factory Method 工厂方法模式
致力于解决：我只想用这个接口，暂时不想实现它，怎么办？写个方法来返回这个接口类型即可。

我这个类做成抽象的，有抽象的方法，也有不抽象的（主要是实现逻辑的）。在客户端调用的时候，抽象类被会赋给它一个子类（多态），这个子类就会把所有的抽象方法都实现了。

本质：延迟到子类来选择实现

设计原则：依赖倒置原则——要依赖抽象，不依赖具体的类
什么倒置了？接口的所有权倒置了   
接口的本来是ExportOperate依赖ExportFileApi（持有它的对象使用它的方法），   
这种一般是说，你ExportFileApi提供什么方法我就用什么方法，   
但是现在情况是，上层ExportOperate我想要什么功能，你这个ExportFileApi接口就要给我提供什么功能，这就是接口的所有权倒置了

# 代码分析

## old
需求：每个客户都有数据，数据格式都是一样的，但想转换成不同的数据格式
- ExportFileApi接口：一个接口，可以使用这个接口中的export方法将数据转换成自己指定的格式。未实现。

## model
面向接口编程
- Product接口：一些需要的接口资源，可能有ProductA、ProductB、ProductC......
- ConcreteProduct类：实现了上面的接口，ProductA可能有ConcreteProductA1、ConcreteProductA2，ConcreteProductA3......等实现类
- Creator抽象类：使用Product接口做一些工作，却不想用它的子类实例初始化它
- ConcreteCreator类：继承了Creator，实现了里面的所有抽象方法，尤其是一个获得Product类的方法

## concrete
- ExportFileApi接口：对外提供数据转换的接口
- ExportDB类：实现了ExportFileApi接口，导出数据为数据库文件
- ExportTxtFile类：实现了ExportFileApi接口，导出数据为txt文件
- ExportOperate抽象类：使用ExportFileApi接口实现导出数据为指定文件这部分逻辑

- ExportDBOpetate类：继承ExportOperate抽象类，实现抽象方法factoryMethod，返回ExportFileApi接口的ExportDB实现类，这样父类中就会导出数据库文件
- ExportTxtFileOperate类：同理，使父类导出数据为指定文件这部分逻辑中的导出数据为txt文件

>IoC/DI 依赖注入控制反转 跟上面concrete类似   
传统A类需要C类都是直接作为成员变量，这是正转  
现在A类需要通过容器获得C类。对于A类而言依赖容器即持有容器对象，注入即容器注入C类；对于容器而言，反向向A类注入C类。  
优势：有效地分离了对象和它所需要的外部资源。松了耦合，提高了灵活性。

## advanced 参数化的工厂方法模式，比上面简单
- ExportOperate类：最大的变化，不再为抽象类，继而factoryMethod也就自己实现了，内容为根据参数选择实现类型。   
这样做很有利于扩展
- ExportXml类：实现ExportFileApi接口，新扩展的导出数据类型
- ExportOperateMore类：继承ExportOperate，因为扩展了一个ExportXml实现，所以在不更改ExportOperate的基础上，重写factoryMethod方法，增加导出数据为xml的功能。




# 存在的问题
- 为什么使用protected而不用privite呢？








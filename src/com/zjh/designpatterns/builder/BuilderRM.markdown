# Builder 生成器模式
Builder负责提供所有的步骤方法，这些步骤方法都是生产自己持有产品的过程，但它不知道这些方法的执行顺序，Director负责将这些方法按规定的顺序运行与处理，最后客户端需要Builder中的产品。

实质：分离算法和部件实现
# 代码解析

## old
- ExportHeaderModel类：文件头的数据模型
- ExportBodyModel类：文件体的数据模型
- ExportFooterModel类：文件尾的数据模型
- ExportToTxt类：将以上数据拼接输出到txt文件
- ExportToXml类：将以上数据拼接成Xml文件输出

>存在问题：当增加新的输出模式时，需要新的输出类。   
>对于这些输出类，处理过程是相同的：  
>1. 先拼接文件头的内容
>2. 然后拼接文件体的内容
>3. 再拼接文件尾的内容
>4. 把拼接好的内容输出出去形成文件
>
>如何做到处理过程不变，每个步骤的具体处理方式可以定制
>
## model

- Product接口：定义Bulider要生产的产品
- Builder接口：定义生产产品的一些步骤（方法）
- ConcreteBuilder类：实现Builder接口
- Director类：定义Builder中这些步骤的顺序等

## concrete
- Builder接口：提供存储文件的步骤，但不提供组合方式
- Director类：持有Builder接口，按规定好的顺序组合Builder提供的步骤
- TxtBuilder类：Builder接口的实现类
- XmlBuilder类：Builder接口的实现类

其他的跟old一样，当然Client的调用有改

## advanced
使用生成器生成复杂对象：意思是不断set属性来生成一个对象。
需求：生成保险合同对象
- InsuranceContract类：保险同类。   
特点：构造方法是默认的Protected，只能本目录下的方法能够调用，出了本目录，就只能使用concreteBuilder类来生成。
- ConcreteBuilder类：作用：生成保险合同类。builder对象调用build方法返回InsuranceContract对象。   
特点：只有get方法，set方法全部是返回InsuraceContract对象。

问题：InsuranceContract类和ConcreteBuilder类有相同的成员变量，为什么InsuranceContract类不自己实现这些方法？   
有问题啊，要直接自己调用build方法，build方法必须是static类型，那么要使用成员变量，成员变量必须是static类型，这如果很多对象，static区域不就爆了。
解决办法是：将ConcreteBuilder做成InsuranceConcract的内部类不就行了。就合二为一了，将构造方法私有化，其他人就不能直接new创建了，只能使用构造器。

## advanced2
这是带约束的，类的成员变量之间存在相互约束。   
约束：保险要么和个人签订要么和公司签订，这两个变量有且只能有一个有值，生效日期大于失效日期   
约束可以在set中设置，也可以统一在build方法中设置   
这个包中加了约束，并将InsuranceContract和ConcreteBuilder合二为一   


# 优缺点

# 存在的问题



















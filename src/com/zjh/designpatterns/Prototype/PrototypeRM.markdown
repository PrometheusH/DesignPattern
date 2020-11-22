# Prototype 原型模式
原型模式，实际就是克隆模式，就是创建新对象并对其赋值，与被克隆的对象地址空间不同，成员变量的值都相同（引用类型的值是地址，不同）

原理上跟工厂模式一样，工厂模式是只知道接口，通过接口的方法来创建实例，这个也是只知道接口，通过接口的方法clone创建跟当前接口对象一样的对象（值相同，地址不同）

对于原型模式的子类来说，站在原型接口的角度是原型接口的子类，站在自己的角度，是自己的工厂，能生产跟自己一摸一样的对象。
# 代码分析

## old
有一个订单处理系统，一个订单对象有产品数量成员变量。当数量小于等于1000时，才能被接下来的逻辑处理。所以当大于1000时要拆分成多个不超过1000的多个对象，这多个对象的产品数量加起来还是等于原来的。
- OrderApi接口：订单接口，所有的订单类型都是要实现这个接口。两个方法设置和读取订单的产品数量。
- PersonalOrder类：个人订单类型，实现OrderApi接口
- EnterpriseOrder类：公司订单类型，实现OrderApi接口
- OrderBusiness：订单处理类，处理订单对象，使用的是Order接口，需要获得接口的实现类才能进行订单拆分

问题：如果要增加一个订单类型，就要修改OrderBusiness，这是不合适的，有什么改变最合适的是在客户端改变

## model
- Prototype接口：有一个clone方法，实现的类需要实现这个方法
- ConcretePrototype1类：实现Prototype接口，主要实现clone方法
- ConcretePrototype2类：同上
- Client类：使用Prototype接口的clone方法克隆Prototype类

Client没有特殊说明，都作客户端使用

## concrete
根据model改写old   
- OrderApi：增加clone方法
- PersonalOrder、EnterpriseOrder都重写clone方法，因为成员变量都是值类型的，所以直接都set就可以了

利用的就是多态：虽然写的是调用的接口的clone方法，实际却是由接口背后的子类执行的clone方法，跟工厂一样。这个地方研究一下类的装载

## advanced
Java中的克隆方法   
Java提供了克隆方法，定义在Object类中。   
OrderApi中删除了clone方法，其子类实现Cloneable接口，Cloneable接口没有需要实现的方法，仅仅是一个标示，要重写的是Object中的clone方法


注意订单系统不能使用Java的克隆实现，只是在这里介绍一下怎么用Java的克隆来克隆Personal类与前面做个比较。因为如果接口中没有克隆方法，OrderBusiness中是不能通过接口来克隆对象的。也就不能获得对象，进而进行拆分。

## advanced2 
浅克隆和深克隆   
浅克隆：只能克隆基本类型和String类型，不能克隆引用。   
深克隆：可以克隆引用，当然也能克隆基本类型和String   

把ProductId放到Product类中，这样PersonalOrder持有Product类，就可以演示如何深度复制了。

- ProductPrototype：可以克隆的产品接口
- ProductA：实现了上面接口，定义了产品A

修改PersonalOrder和EnterpriseOrder中有关productId的变动。

## advanced3
用PersonalOrder类演示一下使用Java的克隆方法实现的深度克隆。只要接口中没有克隆方法的都不能实现订单系统。

## advanced4
原型管理器，原型的数目不确定（可以被动态地创建和销毁），在系统中维护一个注册表解决。

注意：直接get获取的是原来的对象，再调用clone方法才是创建新的对象。


## 注意点
原型和new的关系
- 原型和new都是创建一个对象
- 原型（clone方法）创建的对象的属性是有值的，而new创建的对象的属性都是默认的值。


# 综上所述
精髓就两句话（所有的一切都是为这两句话服务）：
```
自己实现：po.setProductA((ProductA) this.productA.cloneProduct());
java自带：po.setProductA((ProductA)this.productA.clone());
```


# Strategy 策略模式

## 分析
### old
向客户报价，不同的客户报价不同
- Price类：if-else形式报价

### model
策略模式模型
- Strategy接口：所有策略的接口
- ConcreteStrategyX类：实现为不同的策略
- Context类：持有Strategy接口，调用策略的执行方法

### concrete
用策略模型实现，向客户报价
- Price类：扮演Context角色
- Strategy接口：各种不同的报价策略的接口

### advanced
每个策略需要不同的参数怎么办？Strategy接口的执行方法用Context作为输入参数。需要的数据从Context中取。

示例：工资支付方式：现金支付、美元支付。然后添加银行卡支付。

第一种方法：新增Context类：PaymentContext2，继承原来的Context类，新的策略（银行卡支付），使用这个类作为传入Context，强转后从里面取银行卡号

- PaymentStrategy是接口
- RMBCash、DollerCash、Card都是策略
- PaymentContext类：持有策略，并调用策略的类
- PaymentContext2类：继承PaymentContext，不想改动原有代码，新增加一个Card策略，需要一个account参数，于是新增加了这类

缺点：如果每增加一个策略类就新增一个Context，会造成上下文对象层次复杂

### advanced2
新增银行卡支付的第二种方式

在Card方法中增加account成员变量

缺点：与其他的策略都是从PaymentContext中获取参数的风格不一样

个人倾向第二种方法

### advanced3
容错恢复机制
当日志记录数据出出错时，把日志记录到文件中

### advanced4
策略模式+模版方法模式

在使用策略模式的过程中发现一系列算法的实现存在公共功能，甚至步骤是一样的，只是局部实现不同

-LogStrategyTemplate类：增加了一个步骤变成两个步骤：第一步先给消息增加时间戳，第二步存储消息
存储数据库 和 存储文件 的算法都需要增加时间戳这个共同的操作，就放到template中了，组装这两个步骤是在log方法中，第二个步骤的具体实现由相应的算法自己实现





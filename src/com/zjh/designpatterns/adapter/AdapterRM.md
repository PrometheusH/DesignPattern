# Adapter 适配器模式
> 有一个接口定义了一个功能，我想通过我自己的接口复用这个功能，我可以新建一个实现了我自己接口的Adapter类，在这个Adapter类中，持有那个接口的对象，使用那个接口的方法即可

# 代码介绍
## old
一个用文件记录日志的功能
- LogModel类：定义写入文件的内容格式

- LogFileOperateApi接口：定义读写文件方法的接口

- LogFileOperate类：实现LogFileOperateApi接口

问题：客户端改用使用数据库存储的接口了，但客户端还想同时使用文件存储的功能

## model 适配器模型
我需要通过Target接口使用Apatee类的方法，但是Adaptee又没有实现Taget接口
解决：用一个适配器类去实现Target接口，持有Adaptee对象，在重写方法中调用Adaptee的方法，在客户端Target = new Adapter就可以了

- Taget接口：客户端正在使用的接口

- Adaptee类：已存在的类，需要被适配

- Adapter类：适配器类，实现Target接口

## concrete
用适配器模型解决old存在的问题

改用第二版，但想兼容第一版，即客户端也可以选择往文件中写入

看上去是使用的LogDBOperatorApi，如果后面的子类是Adapter的话，它的日志存储方法虽然看上去是create、updata，但是却是用文件存储实现的。

- LogDBOperatorApi接口：将数据库中的日志增删改查
- Adapter类：适配器类，将日志与数据数据库的交互的接口利用LogFileOperateApi重新实现，改为将日志与文件交互

## advanced 双向适配器   
存在的意义：   
- 因为第二版不够稳定，所以主要还是用第一版，但数据也要写入第二版的数据库。   
- 客户端只需要修改Api的实现类就可以实现用文件还是数据库读写。   
- 只要可以使用Target或Adaptee的地方就可以用双向适配器替换，尤其适用在两个不同的客户端需要用不同的方式查看同一个对象时使用

- TwoDirectAdapter类，同时实现了Target接口和Adaptee接口   
重写了它们的方法，让LogFileOperateApi的方法用数据库实现，让LogDBOperateApi的方法用读写文件实现
这样Client中   
fileLogApi中是FileLog的文件实现，fileLogApi2中是FileLog的数据库实现+DBlog的文件实现（用不到，不可能第一版的接口调第二版的方法）   
dbLogApi中是dbLog的数据库实现，dbLogApi2中是FileLog的数据库实现（用不到，不可能第二版的接口调第一版的方法）+dbLog的文件实现，跟上面一样
第二版是db版，第一版是file版   
使用第二版的接口背后文件实现就用dbLogApi2，使用第二版接口，背后还是数据实现，就用dbLogApi就好了   
使用第一版的接口往数据库里写，就用fileLogApi2，使用第一版接口还是往文件中写，就用原来的正常的接口

# 优缺点
优点：   
1. 更好的复用性：功能已有接口不兼容，则可使用   
2. 更好的扩展性：可以给已有的系统通过适配器增加新功能
缺点：   
1. 过度使用，会使系统变得凌乱  
明明是调用的A接口，却被适配成B接口，如果太多则是灾难。如果不是很有必要，则用直接重构系统代替适配器

# 相关模式辨析

- 与桥接模式








# Abstract Factory 抽象工厂模式
实质：选择产品簇的实现

# 代码分析

## old
需求：客户告诉装机工程师自己需要的CPU和主板，装机工程师组装电脑

- CPU接口
- IntlCPU类：实现CPU接口，有类变量CPU针脚数
- AMDCPU类：实现CPU接口，有类变量CPU针脚数

- Mainboard接口
- GAMainboard类：实现Mainboard接口，有类变量CPU插槽孔数
- MSIMainboard类：实现Mainboard接口，有类变量CPU插槽孔数

- CPUFacory类：CPU工厂类，提供方法返回CPU接口类型
- MainboardFactory类：主板工厂类，提供方法返回主板方法类型

- ComputerEngineer类：组装工程师类，拿到CPU和主板，组装电脑，
但是客户端没调用还不知道是什么类型的CPU和主板，但是要写组装步骤，所以直接从Factory的方法中获得假的实例先用着

存在问题：CPU针脚和主板插槽一样的应该是一起出现的，不能分开让用户自己去选择，应该提供方两套方案，第一套是IntelCPU、技嘉主板，第二套是AMDCPU，微星主板，让用户选择其中一套方案来安装。

## model
提供创建一系列相关或相互依赖的对象的接口，无需指定它们具体的类

- AbstarctFactory接口：虽然是Abstract开头，却是个接口类型
- AbstractProductA接口：A产品接口
- ProductA1类：实现A产品接口
- ProductA2类：实现A产品接口
- AbstractProductB接口：B产品接口
- ProductB1类：实现B产品接口
- ProductB2类：实现B产品接口

A产品和B产品有联系，必须一组一组地出现，如ProductA1和ProductB1

## concrete
将old中ComputeEngineer使用的CPUFactory和MainboardFactory获取cpu和主板，换成了用AbstractFactory获取。
- AbstractFactory接口：提供多个获取相关联的接口的方法。
- Schema1类：AbstractFactory接口的实现类，里面获取的所有实例都是有某种关系的
- Schema2类：AbstractFactory接口的实现类

其他的跟old一样不解释了

存在问题：当产品簇增加一个时，需要修改接口，及其实现类，不灵活。

## advanced
定义可扩展的抽象工厂   
修改AbstarctFactory接口，使其方法不再返回具体的接口，而是Object类型，统一成了一个方法，通过方法的参数来确定返回的接口类型。修改Schema和Client相关代码。
- MemeoryAPi接口：新增加的产品簇，内存
- HyMemory类：实现Memory接口，现代型号的内训
- Shcema3类：AbstractFactory类的又一个产品簇实现，增加了内存判断

增加之后修改ComputerEngineer类，增加MemoryApi即可。

存在问题：因为createProduct返回的是Object类，所以可能会存在类型转换错误。用的时候需要权衡一下。

## advanced2
DAO 数据访问对象 Date Access Object

业务对象操作订单主记录和子记录，有多种存储方式

问什么这里面的DAOFactory就成了抽象类，而不是接口了呢？？？

# 优缺点
- 优点
  - 分离接口和实现
  - 选择产品簇变得容易
- 缺点：
  - 不太容易扩展新产品
  - 容易造成类层次复杂（假如关系型数据库又分几种，这样需要将关系型数据库也做成抽象工厂，一个抽象工厂嵌套另一个）

# 不明白的问题
- 明明是接口为什么写成Abstrat开头？？因为它是抽象出来的，在CPUFatory上，又往上抽象了一层，CPUFactory是只是用一个CPUApi，而AbstractFactory是使用多个API。

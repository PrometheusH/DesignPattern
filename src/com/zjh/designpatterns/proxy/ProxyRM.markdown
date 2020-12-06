# Proxy代理模式

原理：空间换时间

# 代码分析

## old
需求：读取某个部门下所有员工，不要翻页，在必要的时候可以选择并查看某位员工的详细信息

- UserModel类：持久化对象，映射数据库中的用户表
- UserManager类：逻辑处理类，查询数据库获取数据。

问题：把该部门所有员工查出返回，如果一次性记录太多，每条记录又太大的话，将占用太多内存。

## model



## concrete
解决old问题：当客户查表时，只能看到用户的姓名，当客户想要详细查询时，再根据客户id到数据库中获取详细数据，用时间换空间。

- UserModelApi接口：用户数据对象接口。
- UserModel类：持久化对象类，实现了UserModelApi接口中的，对成员变量进行get和set的方法
有四个成员变量：用户ID，用户姓名，所属部门名称，用户性别
- Proxy对象：代理对象，也实现了UserModelApi接口，但它只有一个成员变量，就是UserModel类。
它实现的UserModel中的所有get、set方法全是操作的成员变量：UserModel对象。初始化时需要用UserModel对象来对Proxy进行初始化。
- UserManager类：逻辑实现类：先查询所有的用户ID和用户姓名。查询方法使用的是Proxy对象返回的Collection<UserModelApi>，其中的UserModelApi全是Proxy。
-Client：当客户端调用时，返回的是UserModelApi类型，它的get、set全是Proxy的get、set，而Proxy的get、set全是操作的它的成员变量UserModel的成员变量。
这就是代理的由来。

在UserModel的外面又套了一层，UserMode是持久层对象，除了User表中的属性，不能给他再添加新的属性了，于是使用Proxy对它又封装了一层，可以添加新的属性，可以使用它的getset方法，也可以重新写getset方法，在里面调用UserModel的getset方法，极为灵活和任性。

虚代理的典型实例：只获取了用户ID和姓名，没有获取性别。相当于是个虚对象。

保护代理跟虚代理一样，不过就是逻辑不同，叫法不同，它在Proxy的set方法写入了必须与当前对象的拥有人一致的名字才能调用被代理对象的set进行设置。










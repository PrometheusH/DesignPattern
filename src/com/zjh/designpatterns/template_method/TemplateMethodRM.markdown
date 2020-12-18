# Template Method 模版方法模式
实质：抽象类定义算法的骨架，将某些步骤延迟到子类实现


## 代码分析
### old
普通用户登陆和工作人员登陆流程相同，但具体处理方式有一点不同
- UserModel用户模型
- LoginModel登陆模型，两个成员变量userId和pwd
- NormalLogin从数据库中取值和逻辑判断

### model
- AbstractClass：抽象类父类，它的抽象方法可以叫做原语操作。
区别构建者模式，构建者是步骤完全由子类实现，而它只是每个步骤中的一些小的不可分的操作，需要不同的实现
他组装步骤（算法骨架）的方法是用final修饰的。
- ConcreteClass：子类：实现上面





# Iterator 迭代器模式

## 代码分析
### old
原来公司是用List进行存储和分析，新收购的公司采用数组。二者遍历方式不同，想让二者统一。   
用一个接口，将二者的变化屏蔽就完了。

### model
- Iterator接口，有索引移动到第一个位置，让索引移动到下一个位置等等方法
- ConcreteIterator类：实现Interator接口，持有Aggregate对象，自己的方法调用aggregate的方法来写成
- Aggregate抽象类：方法为返回一个迭代器类型的对象
- ConcreteAggregate类：继承上面，实现那个方法，返回自己。

### concrete
使用model重写old，达到虽然是访问的不同的聚合对象，但可以用同一个方法去访问它。客户端不需要知道具体的内部实现。

### advanced
使用Java自带迭代器



## 问题
- 抽象类和接口的区别在哪里？
>interface接口：为包外程序提供本包程序的使用方法。方法全部必须是public类型，且不能有实现。
> 
>抽象类一般是包中的接口，可以是protected，不让包外的程序调用，可以有私有成员变量和私有方法。方法可以有默认实现。
>

- cooncrete包中：因为ArrayIteratorImpl中的first、next、isDone、currentIterm实现方法都是一样的能不能将Iterator改成抽象类，将这三个方法当作默认实现。并将aggregate也放到Iterator中。
还有，SalaryManager和PayManager都有get、size、calc，能不能将他们定义到父类中，做抽象方法。
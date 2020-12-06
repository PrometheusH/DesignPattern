# Command命令模式
命令模式的关键：把请求封装成对象。这些对象可以被存储、转发、记录、处理、请求等

通常有一个类负责管理所有的请求，叫做Invoker。

区分谁是动作的执行类，把什么封装成命令对象，谁是管理对象。

本质：封装请求


# 代码分析
## old没有
## model
- Command接口：定义命令，声明执行的方法
- ConcreteCommand类：命令接口实现对象，执行的方法是虚方法，调用持有的接收者的方法
- Receiver类：接收者类，真正执行命令的对象
- Invoker类：持有很多命令对象，并对这些命令对象进行调度
- Client类：将上面四个类组装起来

## concrete
客户不会跟主板打交道，只要按下按钮电脑就正常启动了，就算换了主板，客户也不知道。
- MainBoardApi接口：定义主板的接口，所有的主板都必须有open方法
- GigaMainBoard和MSIMainBoard都是MainBoard的具体类
- Command接口：定义命令类必须提供的方法
- OpenCommand类：实现Command接口，具体方法是虚实现，要调用MainBoardApi的方法
- Box类：持有开机等命令，对它们进行调度
OpenCommand是开机命令。

## advanced
参数化配置。增加一个重启命令，但按钮只有一个，当按下的时候，给这个按钮参数化设置的是重启对象，就使用重启执行重启操作，设置的是开机对象就执行开机操作。   
增加一个ResetCommand，其他的做相应修改。   
创建一个相应主板的重启命令，给机箱，再按重启按钮就是重启操作。   
如果创建相应主板的开机命令给机箱的重启按钮，再按重启按钮就是执行开机操作。与给的有关。   

## advanced2
可撤销的操作，放弃该操作，回到未执行该操作之前。==软件中的撤销功能。
有两种，这里先说第一种，补偿式，又称反操作式。
- OperationApi接口：具体执行操作的类的接口，设置获取结果方法，加减方法
- Operation类：具体执行操作的类，实现上面方法
- Command接口：一个是执行命令的方法，一个是撤销该命令的方法
- AddCommand类、Substract类：实现上面接口
- Calulate类：持有命令，并对这些命令进行管理。

## advanced3
宏命令————包含多个命令的命令

- CookApi接口：cook方法，厨师接口，真正做菜的人
- HotCook、CoolCook类：实现CookApi，实际做菜类
- Command接口：有执行方法
- ChopCommand、DuckCommand、HuangguaCommand类：调用cook的方法做菜
- MenuCommand类：也实现了Command接口，持有一个列表，里面装着很多其他的命令类。但它实现的excute类是将它持有的命令类的执行方法挨个调用一遍。
- Waiter类：有方法组装MenuCommand类，供Client使用

主要就是MenuCommand类

## advanced4
队列请求   
厨师从命令队列中取出一个命令执行，不知道客户是谁
- Command接口：增加了设置命令接收者和获取桌号方法
- CookApi接口：cook方法增加了tableNum参数
- CommandQueue类：是宏命令不是单个命令。
- MenuCommand类：execute方法不再是直接将它所有持有的commmand都执行一遍，而是将自己给CommandQueue。
- CoolCook实现类、HotCook实现类：冷菜厨师和热菜厨师实现厨师接口，做相应的菜。它的run方法只需要从队列中取菜来做就好了，不需要知道其他的。
- CookManager类：它来启动多线程的厨师。

步骤：    
Client首先调用CookManager类启动所有厨师准备做菜。   
接着Waiter点餐，Waiter会生成一个菜单，   
然后Client调用Waiter的orderOver方法，   
orderOver会调用MenuCommand的执行方法，   
MenuCommand会将自己给CommandQueue方法，   
CommandQueue会将MenuCommand的集合中的命令取出来，放到自己的集合中。     
后台的厨师线程每秒会去看一下CommandQueue的集合，如果有命令，就取出命令做菜。

客户端是不知道到底是哪个类做的事情的。

## advanced5
将命令的历史记录保存起来，当系统出现故障时，可以恢复   
将菜单保存起来，出现故障可以重做。

- FileOpeUtil类：读写文件的辅助类，单例
- CommandQueue类：当增加菜单或者厨师拿走一样菜去做时，都更新文件信息
- ChopCommand和DuckCommand，实现Serializable接口，以便将它们向文件中写入。

要么将CommandQueue中的Collection改为以桌号和菜名作为key的map，要么当程序重新启动时不要再重新下单（把client中的for注销），才能实现程序结束重启时，重新接着重启前做菜。

## advanced6
退化的命令模式  
- 没有组装者——model中的Client，而是psvm直接操作Invoker
- Invoker不用再先设置Command，再调用command中的方法。让Command直接作为参数传给方法，方法直接调用。
我Invoker不再转调Command的方法了，而是Command你乖乖写好方法，我回调你的方法。
- PrintService：取消了，具体的做事类没有了，客户端自己用匿名内部类的方法自己写具体实现


# 优缺点
- 优点：
  - 更松散的耦合。客户端和具体对象完全解耦
  - 更动态地控制。把请求封装起来，可以动态地对它进行参数化，队列化和命令化
  - 很自然的复合命令——宏命令
  - 更好的扩展性，完全解耦，扩展时已有实现完全不用变化。
  
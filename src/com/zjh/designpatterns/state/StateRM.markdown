# State 状态模式

## 分析

### old
示例：
在线投票

投一次正常投票

投2-4次无效投票

投5-7次恶意投票，删除开用户的投票结果

投大于8次，加入黑名单，禁止使用该系统

- VoteManager类：用mapVote储存<用户，该用户所投选项>，用mapVoteCount储存<用户，该用户投了多少次票>   
用if-else来判断对于不同的投票次数如何处理

### model
跟策略模式形式相同，但意义赋予的不一样；而且策略模式是客户端控制选择策略，状态模式是上下文对象选择状态
- State接口：所有的状态处理类都继承它
- ConcreteStateX类：具体的状态处理类
- Context类：上下文对象，持有State对象

### concrete
Context（VoteManager）是中心，持有State对象，选择State对象的实现

State对象可以更改Context的成员变量

- VoteState接口：状态处理接口
- XXXVoteState类：具体的每个处理状态的类
- VoteManager类：上下文对象
- NormalVoteState2类：继承NormalVoteState类，是一个扩展功能的示例。当然还需要改VoteManger使这个类生效，不符合OCP原则，不过advanced中的将状态由状态处理类维护，就不会有这个问题了。
### advanced
使用状态处理类来维护状态
- NormalVoteState类：当前状态为投票一次1次，已经结束了，下一个状态为投票两次2次，当来了的时候，直接就取出来做就完了。每一个人都新建一个对象，这样会不会有太多的对象需要存储呢？享元模式来节省内存啊！
- RepeatVoteState类：前五次都提醒不要重复投票，第五次就更改当前用户的状态了，下次这个用户再来就是恶意投票状态了。
- 
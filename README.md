# DesignPattern
Gof设计模式

# 学习方式
现将书看一遍，理清楚各个类之间的关系，再敲代码。最好是回忆着敲，哪里想不起来了重点注意一下。
发现old代码存在的问题，看一下model中的模型，将old中代码复制到concrete，看着重写示例结构示意图（uml类图），用model中模型的方式改造这些代码。


# Git问题
如果master分支合并完了develop分支，忘了再切换回develop分支，直接在master分支上开发了
这怎么办，如何能将当前的修改并入develop。是先提交master再merge到develop还是，能直接将commit的内容保存，切换develop分之后再push？

# IDEA快捷键
Ctrl+A：到行首（达到Home键的效果）
Ctrl+E：到行尾（达到End键的效果）
Ctrl+N：到下一行
Ctrl+P：到上一行
Ctrl+K：从光标处开始删除，知道行尾
fn键+左方向键是HOME
fn键+右方向键是END
fn+上方向键是page up
fn+下方向键是page down

command+option+V：调用方法时，补齐该方法返回的类型和变量
command+option+L：格式化代码
command+N：重写方法、构造函数、getset等
package com.zjh.designpatterns.state.advanced;

public class NormalVoteState implements VoteState {

    @Override
    public void handle(String user, String voteItem, VoteManager vm) {
        vm.getMapVote().put(user,voteItem);
        System.out.println("恭喜你投票成功");
        //当前状态为投票一次1次，已经结束了，下一个状态为投票两次2次，当来了的时候，直接就取出来做就完了。这样会不会有太多的对象需要存储呢？享元模式来节省内存啊！
        vm.getMapState().put(user,new RepeatVoteState());
    }
}

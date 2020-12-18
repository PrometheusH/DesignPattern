package com.zjh.designpatterns.state.Concrete;

public class NormalVoteState2 extends NormalVoteState{
    @Override
    public void handle(String user, String voteItem, VoteManager vm) {
        super.handle(user, voteItem, vm);
        System.out.println("正常投票奖励积分10分");
    }
}

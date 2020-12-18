package com.zjh.designpatterns.state.Concrete;

public class RepeatVoteState implements VoteState{
    @Override
    public void handle(String user, String voteItem, VoteManager vm) {
        //暂时不作任何处理
        System.out.println("请不要重复投票");
    }
}

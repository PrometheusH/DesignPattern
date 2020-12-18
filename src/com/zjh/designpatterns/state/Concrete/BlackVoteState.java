package com.zjh.designpatterns.state.Concrete;

public class BlackVoteState implements VoteState{

    @Override
    public void handle(String user, String voteItem, VoteManager vm) {
        System.out.println("进入黑名单，禁止使用该系统");
    }
}

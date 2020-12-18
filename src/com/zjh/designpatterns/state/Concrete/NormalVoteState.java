package com.zjh.designpatterns.state.Concrete;

public class NormalVoteState implements VoteState{

    @Override
    public void handle(String user, String voteItem, VoteManager vm) {
        vm.getMapVote().put(user,voteItem);
        System.out.println("恭喜你投票成功");
    }
}

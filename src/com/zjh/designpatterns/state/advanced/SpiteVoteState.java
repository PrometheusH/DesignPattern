package com.zjh.designpatterns.state.advanced;

public class SpiteVoteState implements VoteState {
    @Override
    public void handle(String user, String voteItem, VoteManager vm) {
        String s = vm.getMapVote().get(user);
        if (s!=null){
            vm.getMapVote().remove(user);
        }
        System.out.println("你有恶意刷票行为，取消投票资格");
        if (vm.getMapVoteCount().get(user)>=7){
            vm.getMapState().put(user,new BlackVoteState());
        }
    }
}

package com.zjh.designpatterns.state.advanced;

public class RepeatVoteState implements VoteState {
    @Override
    public void handle(String user, String voteItem, VoteManager vm) {
        //暂时不作任何处理
        System.out.println("请不要重复投票");
        //当当前的状态为5时，就要给它设置新的状态了，下次也就是第6次就是恶意投票了
        if (vm.getMapVoteCount().get(user)>=4){
            vm.getMapState().put(user,new SpiteVoteState());
        }
    }
}

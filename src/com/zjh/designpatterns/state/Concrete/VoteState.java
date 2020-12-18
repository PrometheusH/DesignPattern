package com.zjh.designpatterns.state.Concrete;

public interface VoteState {
    public void handle(String user,String voteItem,VoteManager vm);
}

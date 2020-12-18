package com.zjh.designpatterns.state.advanced;

public interface VoteState {
    public void handle(String user, String voteItem, VoteManager vm);
}

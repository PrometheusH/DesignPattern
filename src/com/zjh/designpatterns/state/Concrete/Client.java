package com.zjh.designpatterns.state.Concrete;

public class Client {
    public static void main(String[] args) {
        VoteManager vm = new VoteManager();
        for (int i = 0; i < 8; i++) {
            vm.vote("user1","000002");
        }
    }
}

package com.zjh.designpatterns.state.Concrete;

import java.util.HashMap;
import java.util.Map;

public class VoteManager {
    VoteState state;
    private Map<String ,String> mapVote = new HashMap<>();
    private Map<String ,Integer> mapVoteCount = new HashMap<>();

    //voteItem：投票的选项
    public void vote(String user,String voteItem){
        Integer oldVoteCount = mapVoteCount.get(user);
        if (oldVoteCount==null){
            oldVoteCount = 0;
        }
        oldVoteCount++;
        mapVoteCount.put(user,oldVoteCount);

        if (oldVoteCount==1){
//            state = new NormalVoteState();
            state = new NormalVoteState2();
        }else if (oldVoteCount>1&&oldVoteCount<5){
            state = new RepeatVoteState();
        }else if (oldVoteCount>=5&&oldVoteCount<8){
            state = new SpiteVoteState();
        }else if (oldVoteCount>=8){
            state = new BlackVoteState();
        }
        state.handle(user,voteItem,this);
    }

    public Map<String, String> getMapVote() {
        return mapVote;
    }

    public Map<String, Integer> getMapVoteCount() {
        return mapVoteCount;
    }
}

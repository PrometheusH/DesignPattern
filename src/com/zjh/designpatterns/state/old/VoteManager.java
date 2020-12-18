package com.zjh.designpatterns.state.old;

import java.util.HashMap;
import java.util.Map;

public class VoteManager {
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
            mapVote.put(user,voteItem);
            System.out.println("恭喜你投票成功");
        }else if (oldVoteCount>1&&oldVoteCount<5){
            //暂时不作任何处理
            System.out.println("请不要重复投票");
        }else if (oldVoteCount>=5&&oldVoteCount<8){
            String s = mapVote.get(user);
            if (s!=null){
                mapVote.remove(user);
            }
            System.out.println("你有恶意刷票行为，取消投票资格");
        }else if (oldVoteCount>=8){
            System.out.println("进入黑名单，禁止使用该系统");
        }
    }
}

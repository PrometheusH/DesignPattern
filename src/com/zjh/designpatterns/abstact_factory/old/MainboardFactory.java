package com.zjh.designpatterns.abstact_factory.old;

public class MainboardFactory {
    public static MainboardApi createMainboardApi(int type){
        MainboardApi api = null;
        if (type==1){
            api = new GAMainboard(1156);
        }else if (type==2){
            api = new MSIMainboard(939);
        }
        return api;
    }
}

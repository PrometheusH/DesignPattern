package com.zjh.designpatterns.strategy.advanced3;

public class DbLog implements LogStrategy{
    @Override
    public void log(String msg) {
        //制造错误
        if (msg!=null&&msg.trim().length()>5){
            int a = 5/0;
        }
        System.out.println("现在把 '"+msg+"'记录到数据库中");
    }
}

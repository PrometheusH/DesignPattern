package com.zjh.designpatterns.strategy.advanced4;

public class FileLog extends LogStrategyTemplate{

    public void doLog(String msg) {
        System.out.println("现在把 '"+msg+"'记录到文件中");    }
}

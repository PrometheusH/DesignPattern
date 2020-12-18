package com.zjh.designpatterns.strategy.advanced3;

public class LogContext {
    LogStrategy strategy = null;
    public void log(String msg){
        strategy = new DbLog();
        try {
            strategy.log(msg);
        }catch (Exception err){
            strategy = new FileLog();
            strategy.log(msg);
        }
    }
}

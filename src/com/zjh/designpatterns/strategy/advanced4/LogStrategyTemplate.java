package com.zjh.designpatterns.strategy.advanced4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class LogStrategyTemplate implements LogStrategy {

    public final void log(String msg) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        msg = df.format(new Date())+"   "+msg;
        doLog(msg);
    }

    public abstract void doLog(String msg);
}

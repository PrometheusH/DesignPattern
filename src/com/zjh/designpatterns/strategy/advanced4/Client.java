package com.zjh.designpatterns.strategy.advanced4;

public class Client {
    public static void main(String[] args) {
        //因为加上时间戳之后都大于了5个字，所以都记录到了文件中
        LogContext ctx = new LogContext();
        ctx.log("记录日志");
        ctx.log("再次记录日志");
    }
}

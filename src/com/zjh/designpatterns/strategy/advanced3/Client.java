package com.zjh.designpatterns.strategy.advanced3;

public class Client {
    public static void main(String[] args) {
        LogContext ctx = new LogContext();
        ctx.log("记录日志");
        ctx.log("再次记录日志");
    }
}

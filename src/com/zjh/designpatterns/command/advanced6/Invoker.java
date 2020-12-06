package com.zjh.designpatterns.command.advanced6;

public class Invoker {
    //    private Command command = null;
//
//    public void setCommand(Command cmd){
//        this.command = cmd;
//    }
//
//    public void startPrint(){
//        this.command.execute();
//    }
    public void startPrint(Command command) {
        System.out.println("输出服务前，一些操作执行");
        command.execute();
        System.out.println("输出服务后，一些操作执行");
    }
}

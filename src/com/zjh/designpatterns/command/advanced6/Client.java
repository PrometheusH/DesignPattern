package com.zjh.designpatterns.command.advanced6;

public class Client {
    public static void main(String[] args) {
        Command command = new Command() {
            private String str = "";
            @Override
            public void execute() {
                System.out.println("打印的内容为："+str);
            }

            @Override
            public void setStr(String s) {
                str =s;
            }
        };

        command.setStr("退化的命令模式，类似于Java的回调示例");

        Invoker invoker = new Invoker();
//        invoker.setCommand(command);
        invoker.startPrint(command);
    }
}

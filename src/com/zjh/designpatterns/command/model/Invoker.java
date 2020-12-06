package com.zjh.designpatterns.command.model;

public class Invoker {
    private Command command = null;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void runCommand(){
        command.excute();
    }
}

package com.zjh.designpatterns.command.model;

public class ConcreteCommand implements Command{
    private Receiver receiver = null;
    private String state;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void excute() {
        receiver.action();
    }
}

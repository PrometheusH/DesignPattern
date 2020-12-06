package com.zjh.designpatterns.command.advanced3;


public class ChopCommand implements Command{
    private CookApi cook;

    public void setCook(CookApi cook) {
        this.cook = cook;
    }

    @Override
    public void execute() {
        this.cook.cook("冬瓜排骨汤");
    }
}

package com.zjh.designpatterns.command.advanced3;


public class DuckCommand implements Command{
    private CookApi cook;

    public void setCook(CookApi cook) {
        this.cook = cook;
    }

    @Override
    public void execute() {
        this.cook.cook("北京烤鸭");
    }
}

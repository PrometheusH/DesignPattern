package com.zjh.designpatterns.command.advanced3;


public class HuangguaCommand implements Command{
    private CookApi cook;

    public void setCook(CookApi cook) {
        this.cook = cook;
    }

    @Override
    public void execute() {
        this.cook.cook("凉拌黄瓜");
    }
}

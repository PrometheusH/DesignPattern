package com.zjh.designpatterns.command.advanced5;


import java.io.Serializable;

public class ChopCommand implements Command, Serializable {
    private CookApi cook;
    private int tableNum;
    public void setCook(CookApi cook) {
        this.cook = cook;
    }

    public ChopCommand(int tableNum) {
        this.tableNum = tableNum;
    }

    @Override
    public void execute() {
        this.cook.cook(tableNum,"冬瓜排骨汤");
    }

    @Override
    public void setCookApi(CookApi cookApi) {
        this.cook=cookApi;
    }

    @Override
    public int getTableNum() {
        return tableNum;
    }
}

package com.zjh.designpatterns.command.advanced5;


import java.io.Serializable;

public class DuckCommand implements Command, Serializable {
    private CookApi cook;
    private int tableNum;

    public DuckCommand(int tableNum) {
        this.tableNum = tableNum;
    }

    public void setCookApi(CookApi cook) {
        this.cook = cook;
    }

    @Override
    public void execute() {
        this.cook.cook(tableNum,"北京烤鸭");
    }

    @Override
    public int getTableNum() {
        return tableNum;
    }
}

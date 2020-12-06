package com.zjh.designpatterns.command.advanced4;


public class HuangguaCommand implements Command {
    private CookApi cook;
    private int tableNum;

    public HuangguaCommand(int tableNum) {
        this.tableNum = tableNum;
    }

    public void setCookApi(CookApi cook) {
        this.cook = cook;
    }

    @Override
    public int getTableNum() {
        return tableNum;
    }

    @Override
    public void execute() {
        this.cook.cook(tableNum,"凉拌黄瓜");
    }

}

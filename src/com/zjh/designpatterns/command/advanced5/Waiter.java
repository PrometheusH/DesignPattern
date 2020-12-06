package com.zjh.designpatterns.command.advanced5;

public class Waiter {
    private MenuCommand menuCommand = new MenuCommand();
    public void orderDish(Command cmd){
        menuCommand.addCommand(cmd);
    }

    public void orderOver(){
        this.menuCommand.execute();
    }
}

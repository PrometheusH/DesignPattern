package com.zjh.designpatterns.command.advanced3;

public class Waiter {
    private MenuCommand menuCommand = new MenuCommand();
    public void orderDish(Command cmd){
        CookApi hotCook = new HotCook();
        CookApi coolCook = new CoolCook();

        if (cmd instanceof DuckCommand){
            ((DuckCommand)cmd).setCook(hotCook);
        }else if (cmd instanceof ChopCommand){
            ((ChopCommand)cmd).setCook(hotCook);
        }else if (cmd instanceof HuangguaCommand){
            ((HuangguaCommand)cmd).setCook(coolCook);
        }
        menuCommand.addCommand(cmd);
    }

    public void orderOver(){
        this.menuCommand.execute();
    }
}

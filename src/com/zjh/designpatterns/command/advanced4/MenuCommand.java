package com.zjh.designpatterns.command.advanced4;

import java.util.ArrayList;
import java.util.Collection;

public class MenuCommand implements Command {
    private Collection<Command> col = new ArrayList<>();

    public void addCommand(Command command){
        col.add(command);
    }

    public Collection<Command> getCommand(){
        return this.col;
    }
    @Override
    public void execute() {
        CommandQueue.addMenu(this);
    }

    @Override
    public void setCookApi(CookApi cookApi) {
        //什么都不用做
    }

    @Override
    public int getTableNum() {
        //什么都不用做
        return 0;
    }
}

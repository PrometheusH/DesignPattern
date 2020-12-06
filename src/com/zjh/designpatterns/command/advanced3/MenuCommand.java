package com.zjh.designpatterns.command.advanced3;

import java.util.ArrayList;
import java.util.Collection;

public class MenuCommand implements Command {
    private Collection<Command> col = new ArrayList<>();

    public void addCommand(Command command){
        col.add(command);
    }
    @Override
    public void execute() {
        for (Command cmd:col){
            cmd.execute();
        }
    }
}

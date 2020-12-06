package com.zjh.designpatterns.command.advanced4;

import java.util.ArrayList;
import java.util.List;

public class CommandQueue {
    private static List<Command> cmds = new ArrayList<>();
    public synchronized static void addMenu(MenuCommand menuCommand){
        for (Command cmd:menuCommand.getCommand()){
            cmds.add(cmd);
        }
    }
    public synchronized static Command getOneCommand(){
        Command cmd = null;
        if (cmds.size()>0){
            cmd = cmds.get(0);
            cmds.remove(0);
        }
        return cmd;
    }
}

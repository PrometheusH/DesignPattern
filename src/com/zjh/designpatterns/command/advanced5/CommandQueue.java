package com.zjh.designpatterns.command.advanced5;

import java.util.ArrayList;
import java.util.List;

public class CommandQueue {
    private static List<Command> cmds = null;

    private final static String FILE_NAME = "CmdQueue.txt";
    static {
        cmds = FileOpeUtil.readFile(FILE_NAME);
        if (cmds == null){
            cmds = new ArrayList<Command>();
        }
    }

    public synchronized static void addMenu(MenuCommand menuCommand){
        for (Command cmd:menuCommand.getCommand()){
            cmds.add(cmd);
            FileOpeUtil.writeFile(FILE_NAME,cmds);
        }
    }

    public synchronized static Command getOneCommand(){
        Command cmd = null;
        if (cmds.size()>0){
            cmd = cmds.get(0);
            cmds.remove(0);
            FileOpeUtil.writeFile(FILE_NAME,cmds);
        }
        return cmd;
    }
}

package com.zjh.designpatterns.command.advanced2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private Command addCommand;
    private Command subCommand;

    public void setAddCommand(Command addCommand) {
        this.addCommand = addCommand;
    }

    public void setSubCommand(Command subCommand) {
        this.subCommand = subCommand;
    }
    private List<Command> undoCmds = new ArrayList<>();
    private List<Command> redoCmds = new ArrayList<>();

    public void addPressed(){
        addCommand.execute();
        undoCmds.add(this.addCommand);
    }
    public void substractPressed(){
        subCommand.execute();
        undoCmds.add(this.subCommand);
    }

    public void undoPressed(){
        if (this.undoCmds.size()>0){
            Command cmd = this.undoCmds.get(this.undoCmds.size()-1);
            cmd.undo();
            this.undoCmds.remove(cmd);
            this.redoCmds.add(cmd);
        }else {
            System.out.println("很抱歉没有可以撤销的命令");
        }
    }

    public void redoPressed(){
        if (redoCmds.size()>0){
            Command cmd = this.redoCmds.get(this.redoCmds.size()-1);
            cmd.execute();
            this.undoCmds.add(cmd);
            this.redoCmds.remove(cmd);
        }else {
            System.out.println("很抱歉没有可以恢复的命令");
        }
    }
}

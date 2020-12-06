package com.zjh.designpatterns.command.concrete;

public class Box {
    private Command openCommand;

    public void setOpenCommand(Command openCommand) {
        this.openCommand = openCommand;
    }

    public void openButtonPressed(){
        openCommand.execute();
    }

}

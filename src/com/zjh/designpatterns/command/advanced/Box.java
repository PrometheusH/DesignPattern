package com.zjh.designpatterns.command.advanced;

public class Box {
    private Command openCommand;

    public void setOpenCommand(Command openCommand) {
        this.openCommand = openCommand;
    }

    public void openButtonPressed(){
        openCommand.execute();
    }

    private Command resetCommand;

    public void setResetCommand(Command resetCommand) {
        this.resetCommand = resetCommand;
    }

    public void resetButtonPressed(){
        resetCommand.execute();
    }
}

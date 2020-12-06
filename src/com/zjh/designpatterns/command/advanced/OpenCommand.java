package com.zjh.designpatterns.command.advanced;

public class OpenCommand implements Command {
    private MainBoardApi mainboard;

    public OpenCommand(MainBoardApi mainboard) {
        this.mainboard = mainboard;
    }

    @Override
    public void execute() {
        this.mainboard.open();
    }
}

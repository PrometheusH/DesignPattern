package com.zjh.designpatterns.command.concrete;

import com.zjh.designpatterns.abstact_factory.advanced.MainboardApi;

public class OpenCommand implements Command{
    private MainBoardApi mainboard;

    public OpenCommand(MainBoardApi mainboard) {
        this.mainboard = mainboard;
    }

    @Override
    public void execute() {
        this.mainboard.open();
    }
}

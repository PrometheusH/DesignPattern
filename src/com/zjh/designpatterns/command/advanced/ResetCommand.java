package com.zjh.designpatterns.command.advanced;

public class ResetCommand implements Command{
    private MainBoardApi mainBoard;

    public ResetCommand(MainBoardApi mainBoard) {
        this.mainBoard = mainBoard;
    }

    @Override
    public void execute() {
        mainBoard.reset();
    }
}

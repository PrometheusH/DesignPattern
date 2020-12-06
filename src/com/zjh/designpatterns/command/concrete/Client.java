package com.zjh.designpatterns.command.concrete;

public class Client {
    public static void main(String[] args) {
        MainBoardApi mainBoard = new GigaMainBoard();
        Command command = new OpenCommand(mainBoard);

        Box box = new Box();
        box.setOpenCommand(command);
        box.openButtonPressed();
    }
}

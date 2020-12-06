package com.zjh.designpatterns.command.advanced2;

public class SubstractCommand implements Command{
    private OperationApi operation;
    private int opeNum;

    public SubstractCommand(OperationApi operation, int opeNum) {
        this.operation = operation;
        this.opeNum = opeNum;
    }

    @Override
    public void execute() {
        operation.substract(opeNum);
    }

    @Override
    public void undo() {
        operation.add(opeNum);
    }
}

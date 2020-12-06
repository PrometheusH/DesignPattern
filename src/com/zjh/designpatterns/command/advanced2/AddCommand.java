package com.zjh.designpatterns.command.advanced2;

public class AddCommand implements Command{
    private OperationApi operation = null;
    private int opeNum;
    @Override
    public void execute() {
        this.operation.add(opeNum);
    }

    @Override
    public void undo() {
        this.operation.substract(opeNum);
    }

    public AddCommand(OperationApi operation, int opeNum) {
        this.operation = operation;
        this.opeNum = opeNum;
    }
}

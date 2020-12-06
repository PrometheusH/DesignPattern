package com.zjh.designpatterns.command.advanced2;

public class Operation implements OperationApi {
    private int result;
    @Override
    public int getResult() {
        return result;
    }

    @Override
    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public void add(int num) {
        result+=num;
    }

    @Override
    public void substract(int num) {
        result-=num;
    }
}

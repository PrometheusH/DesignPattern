package com.zjh.designpatterns.command.advanced2;

public interface OperationApi {
    int getResult();
    void setResult(int result);
    void add(int num);
    void substract(int num);
}

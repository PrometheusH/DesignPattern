package com.zjh.designpatterns.command.advanced4;

public interface Command {
    void execute();
    void setCookApi(CookApi cookApi);
    int getTableNum();
}

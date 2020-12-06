package com.zjh.designpatterns.command.advanced5;

public interface Command {
    void execute();
    void setCookApi(CookApi cookApi);
    int getTableNum();
}

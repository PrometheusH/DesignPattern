package com.zjh.designpatterns.adapter.concrete;

import java.util.List;

public interface LogDBOperateApi {
    void createLog(LogModel lm);
    void updateLog(LogModel lm);
    void removeLog(LogModel lm);
    List<LogModel> getAllLog();
}

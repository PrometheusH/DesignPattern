package com.zjh.designpatterns.adapter.advanced;

import java.util.List;

public interface LogFileOpetateApi {
    List<LogModel> readLogFile();
    void writeLogFile(List<LogModel> list);
}

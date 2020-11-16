package com.zjh.designpatterns.adapter.advanced;

import java.util.ArrayList;
import java.util.List;

public class TwoDirectAdapter implements LogDBOperateApi,LogFileOpetateApi {
    private LogDBOperateApi dbLog;
    private LogFileOpetateApi fileLog;

    public TwoDirectAdapter(LogDBOperateApi dbLog, LogFileOpetateApi fileLog) {
        this.dbLog = dbLog;
        this.fileLog = fileLog;
    }

    @Override
    public void createLog(LogModel lm) {
        List<LogModel> list = fileLog.readLogFile();
        list.add(lm);
        fileLog.writeLogFile(list);
    }

    @Override
    public void updateLog(LogModel lm) {
        List<LogModel> list = fileLog.readLogFile();
        for (int i=0;i<list.size();i++){
            if(list.get(i).getLogId().equals(lm.getLogId())){
                list.set(i,lm);
                break;
            }
        }
        fileLog.writeLogFile(list);
    }

    @Override
    public void removeLog(LogModel lm) {
        List<LogModel> list = fileLog.readLogFile();
        list.remove(lm);
        fileLog.writeLogFile(list);
    }

    @Override
    public List<LogModel> getAllLog() {
        return fileLog.readLogFile();
    }

    @Override
    public List<LogModel> readLogFile() {
        return dbLog.getAllLog();
    }

    @Override
    public void writeLogFile(List<LogModel> list) {
        for (LogModel lm:list){
            dbLog.createLog(lm);
        }
    }
}

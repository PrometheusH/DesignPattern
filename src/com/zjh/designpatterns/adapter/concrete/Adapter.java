package com.zjh.designpatterns.adapter.concrete;

import java.util.List;

public class Adapter implements LogDBOperateApi {
    private LogFileOpetateApi adaptee;

    public Adapter(LogFileOpetateApi adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void createLog(LogModel lm) {
        //先获取所有文件内容，再插入新的，再写入文件
        List<LogModel> list = adaptee.readLogFile();
        list.add(lm);
        adaptee.writeLogFile(list);
    }

    @Override
    public void updateLog(LogModel lm) {
        List<LogModel> list = adaptee.readLogFile();
        for (int i=0;i<list.size();i++){
            if (list.get(i).getLogId().equals(lm.getLogId())){
                list.set(i,lm);
                break;
            }
        }
    }

    @Override
    public void removeLog(LogModel lm) {
        List<LogModel> list = adaptee.readLogFile();
        list.remove(lm);
        adaptee.writeLogFile(list);
    }

    @Override
    public List<LogModel> getAllLog() {
        return adaptee.readLogFile();
    }
}

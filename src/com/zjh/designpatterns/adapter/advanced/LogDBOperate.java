package com.zjh.designpatterns.adapter.advanced;

import java.util.List;

public class LogDBOperate implements LogDBOperateApi {
    @Override
    public void createLog(LogModel lm) {
        System.out.println("现在向数据库中插入了一条数据："+lm);
    }

    @Override
    public void updateLog(LogModel lm) {
        System.out.println("现在在数据库中更新了一条数据："+lm);
    }

    @Override
    public void removeLog(LogModel lm) {
        System.out.println("现在在数据库中移除了一条数据："+lm);
    }

    @Override
    public List<LogModel> getAllLog() {
        System.out.println("现在从数据库中读取所有的数据，没有实现返回为null");
        return null;
    }
}

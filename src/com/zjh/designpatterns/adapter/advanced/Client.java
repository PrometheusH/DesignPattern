package com.zjh.designpatterns.adapter.advanced;

import com.zjh.designpatterns.adapter.concrete.Adapter;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        LogModel lm1 = new LogModel();
        lm1.setLogId("001");
        lm1.setOperateUser("admin");
        lm1.setOperateTime("2024-12-12 19:23:11");
        lm1.setLogContent("这是一个测试");

        List<LogModel> list = new ArrayList<LogModel>();
        list.add(lm1);

        LogFileOpetateApi fileLogApi = new LogFileOperate("");
        LogDBOperateApi dbLogApi = new LogDBOperate();

        LogFileOpetateApi fileLogApi2 = new TwoDirectAdapter(dbLogApi,fileLogApi);
        LogDBOperateApi dbLogApi2 = new TwoDirectAdapter(dbLogApi,fileLogApi);


        //先测试从文件操作适配到第二版
        //虽然调用第二版接口但是是文件操作
        dbLogApi2.createLog(lm1);
        List<LogModel> allLog = dbLogApi2.getAllLog();
        System.out.println("alllog="+allLog);

        //测试数据库适配第一版的接口
        fileLogApi2.writeLogFile(list);
        fileLogApi2.readLogFile();

    }
}

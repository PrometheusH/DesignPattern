package com.zjh.designpatterns.adapter.old;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        LogModel lm1 = new LogModel();
        lm1.setLogId("001");
        lm1.setOperateUser("admin");
        lm1.setOperateTime("2022-10-11 19:23:11");
        lm1.setLogContent("这是一个测试");

        List<LogModel> list = new ArrayList<LogModel>();
        list.add(lm1);

        LogFileOpetateApi api = new LogFileOperate("");
        api.writeLogFile(list);

        List<LogModel> readLog = api.readLogFile();
        System.out.println(readLog);

    }
}

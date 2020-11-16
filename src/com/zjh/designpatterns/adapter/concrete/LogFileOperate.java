package com.zjh.designpatterns.adapter.concrete;

import java.io.*;
import java.util.List;

public class LogFileOperate implements LogFileOpetateApi {
    private String LogFileName = "AdapatorLog.log";

    public LogFileOperate(String logFileName) {
        if (logFileName != null && logFileName.trim().length() > 0) {
            LogFileName = logFileName;
        }
    }

    @Override
    public List<LogModel> readLogFile() {
        List<LogModel> list = null;
        ObjectInputStream oin = null;
        File file = new File(this.LogFileName);
        try {
            if (file.exists()) {

                oin = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(file)
                        ));
                list =(List<LogModel>) oin.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (oin!=null){
                    oin.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void writeLogFile(List<LogModel> list) {
        File file = new File(this.LogFileName);
        ObjectOutputStream oout = null;
        try {
            oout = new ObjectOutputStream(
                    new BufferedOutputStream(
                    new FileOutputStream(file)
            ));
            oout.writeObject(list);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                oout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

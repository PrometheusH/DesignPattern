package com.zjh.designpatterns.singleton.old;

import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private String parameterA;
    private String parameterB;

    public String getParameterA() {
        return parameterA;
    }

    public void setParameterA(String parameterA) {
        this.parameterA = parameterA;
    }

    public String getParameterB() {
        return parameterB;
    }

    public void setParameterB(String parameterB) {
        this.parameterB = parameterB;
    }

    public AppConfig() {
        readConfig();
    }

    public void readConfig(){
        Properties p = new Properties();
        InputStream in = null;
        try {
            in = AppConfig.class.getResourceAsStream("AppConfig.properties");
            p.load(in);
            this.parameterA=p.getProperty("paramA");
            this.parameterB=p.getProperty("paramB");
        }catch (Exception e){
            System.out.printf("没有读取到文件");
            e.printStackTrace();
        }finally {
            try {
                in.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

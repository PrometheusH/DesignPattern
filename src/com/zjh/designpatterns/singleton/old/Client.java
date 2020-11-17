package com.zjh.designpatterns.singleton.old;

public class Client {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        String paramA = config.getParameterA();
        String paramB = config.getParameterB();
        System.out.printf("paramA="+paramA+",paramB="+paramB);
    }
}

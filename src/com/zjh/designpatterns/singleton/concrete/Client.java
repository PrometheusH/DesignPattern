package com.zjh.designpatterns.singleton.concrete;

public class Client {
    public static void main(String[] args) {
        AppConfig config = AppConfig.getInstance();
        String paramA = config.getParameterA();
        String paramB = config.getParameterB();
        System.out.printf("paramA="+paramA+",paramB="+paramB);
    }
}

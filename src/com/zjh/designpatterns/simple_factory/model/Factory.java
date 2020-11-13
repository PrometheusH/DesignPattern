package com.zjh.designpatterns.simple_factory.model;

/**
 * 简单工厂模型
 */
public class Factory {
    public static Api createApi(int condition){
        Api api = null;
        if (condition==1){
            api = new ImplA();
        }else if (condition==2){
            api = new ImplB();
        }
        return api;
    }
}

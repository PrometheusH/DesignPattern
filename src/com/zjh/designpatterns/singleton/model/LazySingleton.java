package com.zjh.designpatterns.singleton.model;

public class LazySingleton {
    private static LazySingleton singleton;
    private LazySingleton(){

    }

    public synchronized static LazySingleton getInstance(){
        if (singleton==null){
            singleton = new LazySingleton();
        }
        return singleton;
    }

    //单例可以有自己的方法、属性

}

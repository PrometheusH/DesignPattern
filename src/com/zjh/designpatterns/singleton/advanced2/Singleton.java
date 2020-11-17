package com.zjh.designpatterns.singleton.advanced2;

public class Singleton {
    private  static class SingletonHolder{
        private static Singleton singleton;
    }
    private Singleton(){}

    public static Singleton getInstance(){
        return SingletonHolder.singleton;
    }
}

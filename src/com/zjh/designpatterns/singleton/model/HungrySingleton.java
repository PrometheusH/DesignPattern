package com.zjh.designpatterns.singleton.model;

public class HungrySingleton {
    private static HungrySingleton singleton = new HungrySingleton();
    private HungrySingleton(){

    }
    public static HungrySingleton getInstance(){
        return singleton;
    }
}

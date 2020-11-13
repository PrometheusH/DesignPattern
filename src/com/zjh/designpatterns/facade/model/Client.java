package com.zjh.designpatterns.facade.model;

public class Client {
    public static void main(String[] args) {
        //使用Facade访问另一个系统的类的方法
        new Facade().test();
    }
}

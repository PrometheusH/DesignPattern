package com.zjh.designpatterns.abstact_factory.model;

public class Client {
    public static void main(String[] args) {
        AbstarctFactory factory = new ConcreteFactory2();
        factory.createProductA().prductLock();
        factory.createProductB().productKey();
    }
}

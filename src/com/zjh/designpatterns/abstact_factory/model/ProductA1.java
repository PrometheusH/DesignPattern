package com.zjh.designpatterns.abstact_factory.model;

public class ProductA1 implements AbstractProductA {

    @Override
    public void prductLock() {
        System.out.println("我生产一号锁");
    }
}

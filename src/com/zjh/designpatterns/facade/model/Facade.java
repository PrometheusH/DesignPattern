package com.zjh.designpatterns.facade.model;

/**
 * 外观对象
 */
public class Facade {
    public void test(){
        AModuleApi a = new AModuleImpl();
        a.testA();
        BModuleApi b = new BModuleImpl();
        b.testB();
        CModuleApi c = new CModuleImpl();
        c.testC();
    }
}

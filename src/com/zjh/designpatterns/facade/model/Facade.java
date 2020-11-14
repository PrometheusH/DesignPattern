package com.zjh.designpatterns.facade.model;

/**
 * 外观对象
 */
public class Facade {
    public void test(){
        //只是调用了这些API的一部分方法
        //可以传进参数，获得结果
        AModuleApi a = new AModuleImpl();
        a.testA();
        BModuleApi b = new BModuleImpl();
        b.testB();
        CModuleApi c = new CModuleImpl();
        c.testC();
    }
}

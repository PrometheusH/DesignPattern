package com.zjh.designpatterns.facade.model;

public class AModuleImpl implements AModuleApi{
    @Override
    public void testA() {
        System.out.println("现在在A模块里操作A方法");
    }
}

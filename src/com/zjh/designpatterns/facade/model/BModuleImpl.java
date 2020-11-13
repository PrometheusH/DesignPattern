package com.zjh.designpatterns.facade.model;

public class BModuleImpl implements BModuleApi {
    @Override
    public void testB() {
        System.out.println("现在在B模块里操作testB方法");
    }
}

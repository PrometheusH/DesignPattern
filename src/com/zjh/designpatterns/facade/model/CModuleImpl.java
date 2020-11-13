package com.zjh.designpatterns.facade.model;

public class CModuleImpl implements CModuleApi {
    @Override
    public void testC() {
        System.out.println("现在在C模块里操作testC方法");
    }
}

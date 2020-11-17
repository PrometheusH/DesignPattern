package com.zjh.designpatterns.factory_method.model;

public abstract class Creator {
    protected abstract Product factoryMethod();

    //使用Product接口的方法
    public void someOption(){
        Product product = factoryMethod();
    }
}

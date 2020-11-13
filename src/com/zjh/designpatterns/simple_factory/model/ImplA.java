package com.zjh.designpatterns.simple_factory.model;

public class ImplA implements Api {
    @Override
    public void operation(String s) {
        System.out.println("ImplA实现了接口，输出s："+s);
    }
}

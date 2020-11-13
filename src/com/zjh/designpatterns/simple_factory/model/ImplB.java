package com.zjh.designpatterns.simple_factory.model;

public class ImplB implements Api {
    @Override
    public void operation(String s) {
        System.out.println("ImplB实现了接口，输出s："+s);
    }
}

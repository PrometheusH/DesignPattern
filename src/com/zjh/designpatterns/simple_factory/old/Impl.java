package com.zjh.designpatterns.simple_factory.old;

public class Impl implements Api {
    @Override
    public void test1(String s) {
        System.out.println("实现了接口，输出s："+s);
    }
}

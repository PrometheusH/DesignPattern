package com.zjh.designpatterns.proxy.model;

/**
 * 具体的目标对象，真正被代理的对象
 */
public class RealSubject implements Subject{
    @Override
    public void request() {
        //执行具体的功能处理
    }
}

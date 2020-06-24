package com.zjh.designpatterns.proxy.model;

public class Proxy implements Subject {
    //持有被代理的具体的目标对象
    private RealSubject realSubject = null;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        //在转调具体的目标对象之前，可以执行一些功能处理

        //转调具体的目标对象的方法
        realSubject.request();

        //在转调具体的目标对象之后，可以执行一些功能处理
    }
}

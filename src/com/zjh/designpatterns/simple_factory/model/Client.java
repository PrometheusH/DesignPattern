package com.zjh.designpatterns.simple_factory.model;

/**
 * 功能：通过工厂来创建接口的实现类，实现了客户端和实现类的隔离
 *
 * 但是如果要新增一个实现类，就要修改工厂方法，我不想修改，怎么办？
 */
public class Client {
    public static void main(String[] args) {
        Api api = Factory.createApi(1);
        api.operation("hahha");
    }
}

package com.zjh.designpatterns.simple_factory.old;

/**
 * 这个例子功能：实现了一个接口
 *
 * 接口的思想：封装隔离
 * 封装：封装一组行为
 * 隔离：隔离行为和具体实现
 *
 * 但是！客户端不但知道了接口是什么，还知道了这个接口的具体实现类是哪个，就能知道具体实现，不符合"封装隔离"的思想
 */
public class Client {
    public static void main(String[] args) {
        Api api = new Impl();
        api.test1("哈哈哈");
    }
}

package com.zjh.designpatterns.facade.old;

public class Client {
    public static void main(String[] args) {
        //现在没有配置文件，直接使用默认的配置
        //也就是说，客户端必须对这些模块都有了解，才能够正确地使用它们
        new Presentation().generate();
        new Business().genetate();
        new DAO().generate();
    }
}

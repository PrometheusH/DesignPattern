package com.zjh.designpatterns.flyweight.concrete;

public class Client {

    public static void main(String[] args) {
        //需要先登陆，然后再判断是否有权限
        SecurityMgr mgr = SecurityMgr.getInstance();

        mgr.login("张三");
        mgr.login("李四");
        boolean f1 = mgr.hasPermit("张三","薪资数据","查看");
        boolean f2 = mgr.hasPermit("李四","薪资数据","修改");

        System.out.println("f1=="+f1);
        System.out.println("f2=="+f2);

        for (int i=0;i<3;i++){
            mgr.login("张三"+i);
            System.out.println(mgr.hasPermit("张三"+i,"测试数据","查看"));
        }
    }
}

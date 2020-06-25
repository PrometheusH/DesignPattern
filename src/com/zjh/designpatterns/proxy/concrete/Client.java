package com.zjh.designpatterns.proxy.concrete;

import java.util.Collection;

public class Client {
    public static void main(String[] args) throws Exception {
        UserManager userManager = new UserManager();
        Collection<UserModelApi> col = userManager.getUserByDepId("0101");

        //只显示基本属性
        for (UserModelApi umApi :
                col) {
            System.out.println("用户编号：" + umApi.getUserId()
                    + "，用户姓名：" + umApi.getName()
                    + "，部门名称：" + umApi.getDepName()
            );
        }

        //显示全部属性，或指定属性

        for (UserModelApi umApi :
                col) {
            System.out.println("用户编号：" + umApi.getUserId()
                    + "，用户姓名：" + umApi.getName()
                    + "，部门名称：" + umApi.getDepName()
                    + "，性别：" + umApi.getSex()
            );
        }



    }
}

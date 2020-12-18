package com.zjh.designpatterns.template_method.concrete;

public class Client {
    public static void main(String[] args) {
        LoginModel lm = new LoginModel();
        lm.setLoginId("admin");
        lm.setPwd("212323123");

        LoginTemplate lt = new WorkerLogin();
        LoginTemplate lt2 = new NormalLogin();

        System.out.println("可以登陆工作平台="+lt.login(lm));
        System.out.println("可以进行普通人员登陆="+lt2.login(lm));
    }
}

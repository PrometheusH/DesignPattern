package com.zjh.designpatterns.template_method.concrete;

public class WorkerLogin extends LoginTemplate {
    @Override
    public LoginModel findLoginUser(String loginId) {
        LoginModel lm = new LoginModel();
        lm.setLoginId(loginId);
        lm.setPwd("212323123");
        return lm;
    }

    @Override
    public String encryptPwd(String pwd) {
        System.out.println("密码已经经过md5加密");
        return pwd;
    }
}

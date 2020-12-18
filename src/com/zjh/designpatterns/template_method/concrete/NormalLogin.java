package com.zjh.designpatterns.template_method.concrete;

public class NormalLogin extends LoginTemplate {
    @Override
    public LoginModel findLoginUser(String loginId) {
        LoginModel lm = new LoginModel();
        lm.setLoginId(loginId);
        lm.setPwd("23423");
        return lm;
    }
}

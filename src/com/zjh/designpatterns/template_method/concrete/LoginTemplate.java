package com.zjh.designpatterns.template_method.concrete;

public abstract class LoginTemplate {
    public final boolean login(LoginModel lm){
        LoginModel dblm = this.findLoginUser(lm.getLoginId());
        String encryptPwd = "";
        if (dblm!=null){
            encryptPwd = this.encryptPwd(lm.getPwd());
            lm.setPwd(encryptPwd);
            return this.match(dblm,lm);
        }
        return false;
    }
    public abstract LoginModel findLoginUser(String loginId);

    public String encryptPwd(String pwd){
        return pwd;
    }

    public boolean match(LoginModel dblm,LoginModel lm){
        return dblm.getLoginId().equals(lm.getLoginId())
                &&dblm.getPwd().equals(lm.getPwd());
    }
}

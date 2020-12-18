package com.zjh.designpatterns.template_method.old;

public class NormalLogin {
    public boolean login(LoginModel lm){
        UserModel um = this.findUserByUserId(lm.getUserId());
        if (um!=null)
            return um.getUserId().equals(lm.getUserId())
                    && um.getPwd().equals(lm.getPwd());
        return false;
    }

    public UserModel findUserByUserId(String userId){
        UserModel um = new UserModel();
        um.setUserId(userId);
        um.setName("test");
        um.setPwd("123456");
        um.setUuid("user00001");
        return um;

    }
}

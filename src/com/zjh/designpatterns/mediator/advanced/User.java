package com.zjh.designpatterns.mediator.advanced;

public class User {
    private String userId;
    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean dimission(){
        DepUserMediatorImpl mediator = DepUserMediatorImpl.getInstance();
        mediator.deleteUser(this.userId);
        System.out.println("用户："+this.getUserId()+"，已经被设置为删除");
        return true;
    }
}

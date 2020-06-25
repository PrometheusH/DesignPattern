package com.zjh.designpatterns.proxy.concrete;

public class UserModel implements UserModelApi{
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 部门编号
     */
    private String depName;
    /**
     * 性别
     */
    private String sex;

    @Override
    public String getUserId() {
        return userId;
    }
    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getDepName() {
        return depName;
    }
    @Override
    public void setDepName(String depId) {
        this.depName = depId;
    }
    @Override
    public String getSex() {
        return sex;
    }
    @Override
    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", depName='" + depName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

package com.zjh.designpatterns.mediator.advanced;

import com.zjh.designpatterns.mediator.concrete.Colleague;

import java.util.ArrayList;
import java.util.Collection;

public class DepUserModel {
    //主键
    private String depUserId;
    private String depId;
    private String userId;

    public String getDepUserId() {
        return depUserId;
    }

    public void setDepUserId(String depUserId) {
        this.depUserId = depUserId;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}

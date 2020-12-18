package com.zjh.designpatterns.template_method.old;

public class WorkerLoginModel {
    private String WorkerId,pwd;

    public String getWorkerId() {
        return WorkerId;
    }

    public void setWorkerId(String workerId) {
        WorkerId = workerId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}

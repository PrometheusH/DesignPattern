package com.zjh.designpatterns.proxy.concrete;

/**
 * 定义用户数据对象的接口
 */
public interface UserModelApi {
    public String getUserId();

    public void setUserId(String userId);

    public String getName();

    public void setName(String name);

    //这里是部门名称比较好，否则就没有必要联合dep表进行查询了
    public String getDepName();

    public void setDepName(String depId);

    public String getSex();

    public void setSex(String sex);


}

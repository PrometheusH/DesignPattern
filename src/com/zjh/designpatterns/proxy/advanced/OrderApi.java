package com.zjh.designpatterns.proxy.advanced;

/**
 * 订单对象的接口定义
 */
public interface OrderApi {
    public String getProductName();
    public void setProductName(String productName,String user);
    public int getOrderNum();
    public void setOrderNum(int orderNum,String user);
    public String getOrderUser();
    public void setOrderUser(String orderUser,String user);
}

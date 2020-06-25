package com.zjh.designpatterns.proxy.advanced;

public class Order implements OrderApi {
    /**
     * 订单订购的产品名称
     */
    private String productName;
    /**
     * 订单订购的数量
     */
    private int orderNum;
    /**
     * 创建订单的人员
     */
    private  String orderUser;

    public Order(String productName, int orderNum, String orderUser) {
        this.productName = productName;
        this.orderNum = orderNum;
        this.orderUser = orderUser;
    }

    @Override
    public String getProductName() {
        return this.productName;
    }

    @Override
    public void setProductName(String productName, String user) {
        this.productName = productName;
    }

    @Override
    public int getOrderNum() {
        return this.orderNum;
    }

    @Override
    public void setOrderNum(int orderNum, String user) {
        this.orderNum=orderNum;
    }

    @Override
    public String getOrderUser() {
        return this.orderUser;
    }

    @Override
    public void setOrderUser(String orderUser, String user) {
        this.orderUser = orderUser;
    }

    @Override
    public String toString() {
        return "productName=" + this.getProductName()
                + "，productNum=" + this.getOrderNum()
                + "，orderUser=" + this.getOrderUser()
                ;
    }
}

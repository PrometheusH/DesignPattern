package com.zjh.designpatterns.Prototype.concrete;

public class Client {
    public static void main(String[] args) {
        PersonalOrder po = new PersonalOrder();
        po.setOrderProductNum(2833);
        po.setProductId("p0001");
        po.setCustomerName("张三");

        OrderBusiness ob = new OrderBusiness();
        ob.saveOrder(po);
    }
}

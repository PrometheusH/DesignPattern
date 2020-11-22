package com.zjh.designpatterns.Prototype.advanced2;

public class Client {
    public static void main(String[] args) {
        PersonalOrder po = new PersonalOrder();
        po.setOrderProductNum(2833);
        po.setProductA(new ProductA("产品A","001"));
        po.setCustomerName("张三");

        OrderBusiness ob = new OrderBusiness();
        ob.saveOrder(po);
    }
}

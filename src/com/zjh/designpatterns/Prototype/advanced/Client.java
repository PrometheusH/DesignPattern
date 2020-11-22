package com.zjh.designpatterns.Prototype.advanced;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException{
        PersonalOrder po = new PersonalOrder();
        po.setCustomerName("李四");
        po.setOrderProductNum(300);
        po.setProductId("011");

        System.out.println(po);

        PersonalOrder po2 = (PersonalOrder) po.clone();
        po2.setOrderProductNum(233);
        System.out.println(po2);
    }
}

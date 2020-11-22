package com.zjh.designpatterns.Prototype.advanced3;

public class Client {
    public static void main(String[] args) {
        PersonalOrder po = new PersonalOrder();
        po.setOrderProductNum(2833);
        po.setProductA(new ProductA("产品A","001"));
        po.setCustomerName("张三");
        System.out.println(po);

        PersonalOrder po2 = (PersonalOrder) po.clone();
        po2.setOrderProductNum(2333);
        System.out.println(po2);

    }
}

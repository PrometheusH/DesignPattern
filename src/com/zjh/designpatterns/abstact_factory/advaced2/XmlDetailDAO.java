package com.zjh.designpatterns.abstact_factory.advaced2;

public class XmlDetailDAO implements OrderDetailDAO {
    @Override
    public void saveOrderDetail() {
        System.out.println("现在使用Xml存储订单子类");
    }
}

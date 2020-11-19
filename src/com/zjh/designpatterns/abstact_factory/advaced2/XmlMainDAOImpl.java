package com.zjh.designpatterns.abstact_factory.advaced2;

public class XmlMainDAOImpl implements OrderMainDAO{
    @Override
    public void saveOrderMain() {
        System.out.println("现在使用Xml存储订单主类");
    }
}

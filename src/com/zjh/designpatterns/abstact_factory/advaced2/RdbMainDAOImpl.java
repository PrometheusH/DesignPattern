package com.zjh.designpatterns.abstact_factory.advaced2;

public class RdbMainDAOImpl implements OrderMainDAO{
    @Override
    public void saveOrderMain() {
        System.out.println("使用数据库存储订单主记录");
    }
}

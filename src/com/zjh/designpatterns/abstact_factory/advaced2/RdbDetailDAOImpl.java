package com.zjh.designpatterns.abstact_factory.advaced2;

public class RdbDetailDAOImpl implements OrderDetailDAO{
    @Override
    public void saveOrderDetail() {
        System.out.println("使用数据库存储订单子类");
    }
}

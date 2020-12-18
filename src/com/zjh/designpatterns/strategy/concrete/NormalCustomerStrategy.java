package com.zjh.designpatterns.strategy.concrete;

public class NormalCustomerStrategy implements Strategy {
    @Override
    public double calcPrice(double goodsPrice) {
        System.out.println("对于普通客户没有折扣");
        return goodsPrice;
    }
}

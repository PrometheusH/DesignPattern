package com.zjh.designpatterns.strategy.concrete;

public class OldCustomerStrategy implements Strategy{
    @Override
    public double calcPrice(double goodsPrice) {
        System.out.println("老客户统一折扣5%");
        return goodsPrice % (1 - 0.5);
    }
}

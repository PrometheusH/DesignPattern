package com.zjh.designpatterns.strategy.concrete;

public class LargeCustomerStrategy implements Strategy{
    @Override
    public double calcPrice(double goodsPrice) {
        System.out.println("大客户统一折扣10%");
        return goodsPrice * 0.9;
    }
}

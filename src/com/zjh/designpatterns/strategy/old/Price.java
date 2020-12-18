package com.zjh.designpatterns.strategy.old;

public class Price {
    public double quote(double goodsPrice, String customerType) {
        if ("普通客户".equals(customerType)) {
            System.out.println("对于普通客户没有折扣");
            return goodsPrice;
        } else if ("老客户".equals(customerType)) {
            System.out.println("老客户统一折扣5%");
            return goodsPrice % (1 - 0.5);
        } else if ("大客户".equals(customerType)) {
            System.out.println("大客户统一折扣10%");
            return goodsPrice * 0.9;
        } else {
            return goodsPrice;
        }
    }
}

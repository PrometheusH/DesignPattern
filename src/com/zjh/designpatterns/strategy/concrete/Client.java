package com.zjh.designpatterns.strategy.concrete;

public class Client {
    public static void main(String[] args) {
        Strategy strategy = new LargeCustomerStrategy();
        Price price = new Price(strategy);
        double quote = price.quote(1000);
        System.out.println("向大客户报价："+quote);
    }
}

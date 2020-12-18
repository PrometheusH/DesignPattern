package com.zjh.designpatterns.strategy.advanced2;

public class Client {
    public static void main(String[] args) {
        PaymentStrategy dollarCash = new DollarCash();
        PaymentContext context = new PaymentContext("张三",10000,dollarCash);

        context.payNow();

        PaymentStrategy card = new Card("2341353452452");
        PaymentContext context2 = new PaymentContext("李四",10000,card);

        context2.payNow();
    }
}

package com.zjh.designpatterns.strategy.advanced;

public class Client {
    public static void main(String[] args) {
        PaymentStrategy dollarCash = new DollarCash();
        PaymentContext context = new PaymentContext("张三",10000,dollarCash);

        context.payNow();

        PaymentStrategy card = new Card();
        PaymentContext2 context2 = new PaymentContext2("李四",10000,"2345234524624624626",card);

        context2.payNow();
    }
}

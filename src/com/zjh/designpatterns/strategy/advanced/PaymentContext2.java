package com.zjh.designpatterns.strategy.advanced;

public class PaymentContext2 extends PaymentContext{
    private String account;
    public PaymentContext2(String userName, double money,String account,PaymentStrategy paymentStrategy) {
        super(userName, money, paymentStrategy);
        this.account = account;
    }

    public String getAccount() {
        return account;
    }
}

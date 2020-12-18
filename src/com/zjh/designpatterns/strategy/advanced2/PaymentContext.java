package com.zjh.designpatterns.strategy.advanced2;

public class PaymentContext {
    private String userName = null;
    private double money= 0.0;
    private PaymentStrategy paymentStrategy = null;

    public PaymentContext(String userName, double money, PaymentStrategy paymentStrategy) {
        this.userName = userName;
        this.money = money;
        this.paymentStrategy = paymentStrategy;
    }
    public void payNow(){
        this.paymentStrategy.pay(this);
    }

    public String getUserName() {
        return userName;
    }

    public double getMoney() {
        return money;
    }
}

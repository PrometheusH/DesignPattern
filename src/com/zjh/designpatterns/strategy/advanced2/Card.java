package com.zjh.designpatterns.strategy.advanced2;

public class Card implements PaymentStrategy {
    private String account;

    public Card(String account) {
        this.account = account;
    }

    @Override
    public void pay(PaymentContext pctx) {
        System.out.println("现在给 "+pctx.getUserName()+" 银行卡 "+this.account+" 支付："+pctx.getMoney()+" 元");

    }
}

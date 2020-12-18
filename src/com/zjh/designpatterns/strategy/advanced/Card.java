package com.zjh.designpatterns.strategy.advanced;

public class Card implements PaymentStrategy{
    @Override
    public void pay(PaymentContext pctx) {
        PaymentContext2 pctx2 = (PaymentContext2)pctx;
        System.out.println("现在给 "+pctx.getUserName()+" 银行卡 "+pctx2.getAccount()+" 支付："+pctx.getMoney()+" 元");

    }
}

package com.zjh.designpatterns.strategy.advanced;

public class RMBCash implements PaymentStrategy{
    @Override
    public void pay(PaymentContext pctx) {
        System.out.println("现在给 "+pctx.getUserName()+" 人民币现金支付："+pctx.getMoney()+" 元");
    }
}

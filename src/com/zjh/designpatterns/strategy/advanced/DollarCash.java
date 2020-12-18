package com.zjh.designpatterns.strategy.advanced;

public class DollarCash implements PaymentStrategy{
    @Override
    public void pay(PaymentContext pctx) {
        System.out.println("现在给 "+pctx.getUserName()+" 美元现金支付："+pctx.getMoney()+" 美元");
    }
}

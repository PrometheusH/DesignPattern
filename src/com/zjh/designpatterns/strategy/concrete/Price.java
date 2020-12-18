package com.zjh.designpatterns.strategy.concrete;

public class Price {
    Strategy strategy;

    public Price(Strategy strategy) {
        this.strategy = strategy;
    }

    public double quote(double goodsPrice){
        return  strategy.calcPrice(goodsPrice);
    }

}

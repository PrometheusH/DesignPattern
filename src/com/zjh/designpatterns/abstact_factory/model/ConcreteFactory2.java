package com.zjh.designpatterns.abstact_factory.model;

public class ConcreteFactory2 implements AbstarctFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}

package com.zjh.designpatterns.abstact_factory.model;

public class ConcreteFactory1 implements AbstarctFactory{
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}

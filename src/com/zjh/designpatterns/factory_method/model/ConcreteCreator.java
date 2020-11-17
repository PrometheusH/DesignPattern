package com.zjh.designpatterns.factory_method.model;

public class ConcreteCreator extends Creator{
    @Override
    protected Product factoryMethod() {
        return new ConcreteProduct();
    }
}

package com.zjh.designpatterns.Prototype.model;

public class ConcretePrototype1 implements Prototype{
    @Override
    public Prototype clone() {
        ConcretePrototype1 prototype = new ConcretePrototype1();
        return prototype;
    }
}

package com.zjh.designpatterns.Prototype.model;

public class ConcretePrototype2 implements Prototype{
    @Override
    public Prototype clone() {
        ConcretePrototype2 cp2 = new ConcretePrototype2();
        return cp2;
    }
}

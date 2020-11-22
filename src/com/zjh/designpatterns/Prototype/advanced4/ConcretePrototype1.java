package com.zjh.designpatterns.Prototype.advanced4;

public class ConcretePrototype1 implements Prototype {
    private String name;
    @Override
    public Prototype clone() {
        ConcretePrototype1 cp1 = new ConcretePrototype1();
        cp1.setName(this.name);
        return cp1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

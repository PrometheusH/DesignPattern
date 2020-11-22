package com.zjh.designpatterns.Prototype.advanced4;

import com.zjh.designpatterns.Prototype.model.ConcretePrototype1;

public class ConcretePrototype2 implements Prototype {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Prototype clone() {

        ConcretePrototype2 cp2 =  new ConcretePrototype2();
        cp2.setName(this.name);
        return cp2;
    }
}

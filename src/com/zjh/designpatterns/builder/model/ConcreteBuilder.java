package com.zjh.designpatterns.builder.model;

public class ConcreteBuilder implements Builder{
    private Product product;
    public  Product getResult(){
        return product;
    }
    @Override
    public void buildPart() {

    }
}

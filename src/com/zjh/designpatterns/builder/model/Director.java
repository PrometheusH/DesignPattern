package com.zjh.designpatterns.builder.model;

public class Director {
    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    public void contruct(){
        builder.buildPart();
    }
}

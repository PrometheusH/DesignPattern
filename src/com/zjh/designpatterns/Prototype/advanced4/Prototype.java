package com.zjh.designpatterns.Prototype.advanced4;

public interface Prototype {
    public Prototype clone();
    String getName();
    void setName(String name);
}

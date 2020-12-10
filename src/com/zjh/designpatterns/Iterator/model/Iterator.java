package com.zjh.designpatterns.Iterator.model;

public interface Iterator {
    void first();
    void next();
    boolean isDone();
    Object currentItem();
}

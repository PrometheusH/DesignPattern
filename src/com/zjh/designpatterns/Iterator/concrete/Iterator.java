package com.zjh.designpatterns.Iterator.concrete;

public interface Iterator {
    void first();
    void next();
    boolean isDone();
    Object currentItem();
}

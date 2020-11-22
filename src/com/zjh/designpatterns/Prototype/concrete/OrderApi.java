package com.zjh.designpatterns.Prototype.concrete;

public interface OrderApi {
    int getOrderProductNum();
    void setOrderProductNum(int num);
    OrderApi clone();
}

package com.zjh.designpatterns.Prototype.advanced2;

public interface OrderApi {
    int getOrderProductNum();
    void setOrderProductNum(int num);
    OrderApi clone();
}

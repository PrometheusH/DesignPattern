package com.zjh.designpatterns.observer.model;

/**
 * 读者类的抽象接口
 */
public interface Observer {
    public void update(Subject subject);
}

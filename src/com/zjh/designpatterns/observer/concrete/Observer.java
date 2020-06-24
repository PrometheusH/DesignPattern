package com.zjh.designpatterns.observer.concrete;

/**
 * 目标对象通过这个方法来更新这个接口的子类对象
 */
public interface Observer {
    public void update(Subject subject);
}

package com.zjh.designpatterns.observer.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标对象，它知道观察它的观察者，并提供注册和观察者接口
 */

public class Subject {
    /**
     * 用来保存注册的观察者对象
     */
    private List<Observer> observers = new ArrayList<Observer>();

    /**
     * 注册观察者对象
     *
     * @param observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 删除观察者对象
     * @param observer
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知所有注册的观察者对象
     */
    public void notifyObservers() {
        for (Observer observer :
                observers) {
            observer.update(this);
        }
    }
}

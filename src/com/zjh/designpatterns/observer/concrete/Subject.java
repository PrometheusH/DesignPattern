package com.zjh.designpatterns.observer.concrete;

import java.util.ArrayList;
import java.util.List;

/**
 * 接受读者的订阅与取消，管理读者
 */

public class Subject {
    /**
     * 用来保存注册的读者
     */
    private List<Observer> observers = new ArrayList<Observer>();

    /**
     * 读者要订阅，先注册自己
     *
     * @param observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 取消订阅
     * @param observer
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 报纸出来后通知读者来取
     */
    public void notifyObservers() {
        for (Observer observer :
                observers) {
            observer.update(this);
        }
    }
}

package com.zjh.designpatterns.observer.another_advanced;

import java.util.ArrayList;
import java.util.List;


/**
 * 水质检测
 */
public abstract class WaterQualitySubject {
    protected List<WatcherObserver> observers = new ArrayList<>();

    public void attach(WatcherObserver observer){
        observers.add(observer);
    }

    public void detach(WatcherObserver observer){
        observers.remove(observer);
    }

    public abstract void notifyObservers();

    public abstract int getPolluteLevel();

    public abstract void setPolluteLevel(int polluteLevel);

}

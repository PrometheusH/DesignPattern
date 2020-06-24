package com.zjh.designpatterns.observer.another_advanced;

/**
 * 观察者接口
 */
public interface WatcherObserver {

    public void update(WaterQualitySubject subject);

    public void setJob(String job);

    public String getJob();
}

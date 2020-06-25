package com.zjh.designpatterns.observer.another_advanced;

/**
 * 这个例子：对订阅同一个主题的不同的观察者不同处理
 */
public class Client {
    public static void main(String[] args) {
        WaterQuality subject = new WaterQuality();

        WatcherObserver watcher1 = new Watcher();
        watcher1.setJob("监测人员");
        WatcherObserver watcher2 = new Watcher();
        watcher2.setJob("预警人员");
        WatcherObserver watcher3 = new Watcher();
        watcher3.setJob("部门领导");

        subject.attach(watcher1);
        subject.attach(watcher2);
        subject.attach(watcher3);

        System.out.println("当水质为正常的时候：----------------");
        subject.setPolluteLevel(0);
        System.out.println("当水质为轻度污染的时候：----------------");
        subject.setPolluteLevel(1);
        System.out.println("当水质为重度污染的时候：----------------");
        subject.setPolluteLevel(2);

    }

}

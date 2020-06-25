package com.zjh.designpatterns.observer.model;

/**
 * 具体的目标对象
 * 将自己的状态告诉各个观察者
 */
public class ConcreteSubject extends Subject{
    /**
     * 目标对象的状态
     */
    private String subjectState;
    public String getSubjectState(){
        return subjectState;
    }

    public void setSubjectState(){
        this.subjectState = subjectState;
        //状态发生改变，通知各个观察者
        this.notifyObservers();
    }
}

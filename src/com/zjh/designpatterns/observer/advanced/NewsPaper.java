package com.zjh.designpatterns.observer.advanced;

import java.util.Observable;

/**
 * 使用Java自带的观察者模式
 */
public class NewsPaper extends Observable {
    /**
     * 报纸内容
     */
    private String content;

    /**
     * 读者获取报纸的具体内容，就可以阅读了
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置报纸的内容，相当于出版一期新的报纸
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
        //报纸更新了，通知读者，使用Java的方法
        //必须要调用这个方法
        this.setChanged();
        //使用推的方式，我知道Reader要内容，只给他推送这个内容
        this.notifyObservers(this.content);
        //使用拉的方式
        //this.notifyObservers();
    }
}

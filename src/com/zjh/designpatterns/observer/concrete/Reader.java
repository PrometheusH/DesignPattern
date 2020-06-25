package com.zjh.designpatterns.observer.concrete;

public class Reader implements Observer {
    /**
     * 读者姓名
     */
    private String name;

    /**
     * 通知报社读者后，读者的操作
     * @param subject
     */
    @Override
    public void update(Subject subject) {
        System.out.println(name+"去取报纸了，取到了，内容是："+((NewsPaper)subject).getContent());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


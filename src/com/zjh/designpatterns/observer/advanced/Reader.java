package com.zjh.designpatterns.observer.advanced;

import java.util.Observable;

public class Reader implements java.util.Observer {
    /**
     * 读者姓名
     */
    private String name;

    /**
     * 通知报社读者后，读者的操作
     */
    @Override
    public void update(Observable o, Object arg) {
        //使用推的方式
        System.out.println(name+"去取报纸了，取到了，内容是："+arg);

        //使用拉的方式，arg为null
        //System.out.println(name+"去取报纸了，取到了，内容是："+((NewsPaper)o).getContent());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

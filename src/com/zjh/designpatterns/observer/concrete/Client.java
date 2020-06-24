package com.zjh.designpatterns.observer.concrete;

public class Client {
    public static void main(String[] args) {
        NewsPaper newsPaper = new NewsPaper();

        Reader reader1 = new Reader();
        reader1.setName("张三");

        Reader reader2 = new Reader();
        reader2.setName("李四");

        Reader reader3 = new Reader();
        reader3.setName("王五");

        newsPaper.attach(reader1);
        newsPaper.attach(reader2);
        newsPaper.attach(reader3);

        newsPaper.setContent("第一期报纸，观察者模式研磨");
    }
}

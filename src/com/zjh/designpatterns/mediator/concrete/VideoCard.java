package com.zjh.designpatterns.mediator.concrete;

public class VideoCard extends Colleague{
    public VideoCard(Mediator mediator) {
        super(mediator);
    }
    public void showData(String data){
        System.out.println("您现在看到的是："+data);
    }
}

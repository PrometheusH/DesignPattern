package com.zjh.designpatterns.mediator.concrete;

public class SoundCard extends Colleague {
    public SoundCard(Mediator mediator) {
        super(mediator);
    }

    public void  soundData(String data){
        System.out.println("您现在听到的是："+data);
    }

}

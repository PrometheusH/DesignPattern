package com.zjh.designpatterns.mediator.concrete;

public class Client {
    public static void main(String[] args) {
        MotherBoard mediator = new MotherBoard();
        CDDriver cdDriver = new CDDriver(mediator);
        CPU cpu = new CPU(mediator);
        VideoCard videoCard = new VideoCard(mediator);
        SoundCard soundCard = new SoundCard(mediator);
        mediator.setCdDriver(cdDriver);
        mediator.setCpu(cpu);
        mediator.setSoundCard(soundCard);
        mediator.setVideoCard(videoCard);
        cdDriver.readCD("一个大象,哞牟叫");
    }
}

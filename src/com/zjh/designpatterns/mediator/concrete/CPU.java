package com.zjh.designpatterns.mediator.concrete;

public class CPU extends Colleague {
    //分解出来的视频数据
    private String videoData;
    //解析出来的声音数据
    private String soundData;
    public CPU(Mediator mediator) {
        super(mediator);
    }
    //业务方法，也是跟中介者交互的方法
    //解析光盘的数据
    public void excuteData(String data){
        String[] ss = data.split(",");
        this.videoData = ss[0];
        this.soundData = ss[1];
        this.getMediator().changed(this);
    }

    public String getVideoData() {
        return videoData;
    }

    public String getSoundData() {
        return soundData;
    }
}

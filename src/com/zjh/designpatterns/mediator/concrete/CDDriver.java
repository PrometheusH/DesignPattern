package com.zjh.designpatterns.mediator.concrete;

public class CDDriver extends Colleague {
    private String data;

    public CDDriver(Mediator mediator) {
        super(mediator);
    }

    public void readCD(String data){
        this.setData(data);
        this.getMediator().changed(this);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}


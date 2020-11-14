package com.zjh.designpatterns.mediator.model;

public class ConcreteCollegueB extends Colleague {
    public ConcreteCollegueB(Mediator mediator) {
        super(mediator);
    }
    public void someOperation(){
        //告诉中介者我要改变了，让它再去告诉其他的同事类
        getMediator().change(this);
    }
}

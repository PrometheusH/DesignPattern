package com.zjh.designpatterns.mediator.model;

public class ConcreteMediator implements Mediator {
    private ConcreteCollegueA CollegueA;
    private ConcreteCollegueB CollegueB;

    public void setCollegueA(ConcreteCollegueA collegueA) {
        CollegueA = collegueA;
    }

    public void setCollegueB(ConcreteCollegueB collegueB) {
        CollegueB = collegueB;
    }

    @Override
    public void change(Colleague colleague) {
        //可以在抽象的同事类中设置一个变量，来判断是哪个具体的同事类发生的变化，进而进行处理
    }
}

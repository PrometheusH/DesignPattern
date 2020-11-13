package com.zjh.designpatterns.facade.concrete;

public class Facade {
    public void generate(){
        new Presentation().generate();
        new Business().genetate();
        new DAO().generate();
    }
}

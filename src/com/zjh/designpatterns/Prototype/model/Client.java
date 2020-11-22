package com.zjh.designpatterns.Prototype.model;

public class Client {
    //相当于OrderBusiness
    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public void operation(){
        Prototype newPrototype = prototype.clone();
    }

}

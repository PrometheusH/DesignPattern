package com.zjh.designpatterns.template_method.model;

public abstract class AbstractClass {
    public abstract void doPrimitiveOperation1();
    public abstract void doPrimitiveOperation2();

    public final void templateMethod(){
        doPrimitiveOperation1();
        doPrimitiveOperation2();
    }
}

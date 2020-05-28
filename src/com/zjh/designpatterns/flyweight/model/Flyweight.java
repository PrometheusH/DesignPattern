package com.zjh.designpatterns.flyweight.model;

/**
 * 享元接口，通过这个接口可以接受并作用于外部状态
 *
 */
public interface Flyweight {

    public void operation(String extrinsicState);

}

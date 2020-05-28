package com.zjh.designpatterns.flyweight.model;

/**
 * 权限模型不需要共享的属性
 */
public class UnsharedConcreteFlyweight implements Flyweight{
    /**
     * 示例，描述对象的状态
     */
    private String allState;


    @Override
    public void operation(String extrinsicState) {
        //具体的处理功能
    }
}

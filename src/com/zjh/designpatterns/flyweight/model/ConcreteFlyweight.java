package com.zjh.designpatterns.flyweight.model;

public class ConcreteFlyweight implements Flyweight {
    /**
     * 示例，描述内部状态
     */
    private String intrinsicState;

    /**
     * 构造方法，传入享元对象的内部状态数据
     * @param intrinsicState
     */
    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        //具体的处理功能，可能会用到享元内部、外部状态
    }


}

package com.zjh.designpatterns.composite.model;

/**
 * 抽象的组件对象，为组合中的对象声明接口，实现接口的缺省行为
 */
public abstract class Component {

    /**
     * 示意方法，子对象可能有的功能
     */
    public abstract void someOperation();

    public void addChild(Component child){
        /**
         * 缺省的实现，抛出例外，因为叶子对象没有这个功能或自组件没有实现这个功能
         */
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    /**
     * 从组合对象中移除某个组件对象
     * @param child
     */
    public void removeChild(Component child){
        /**
         * 缺省的实现，抛出例外，因为叶子对象没有这个功能或自组件没有实现这个功能
         */
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    /**
     * 返回某个索引对应的组件对象
     * @param index
     */
    public Component getChildren(int index){
        /**
         * 缺省的实现，抛出例外，因为叶子对象没有这个功能或自组件没有实现这个功能
         */
        throw new UnsupportedOperationException("对象不支持这个功能");
    }
}

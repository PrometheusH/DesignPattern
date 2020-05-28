package com.zjh.designpatterns.flyweight.concrete;


import java.util.ArrayList;
import java.util.List;

/**
 * 权限模型不需要共享的属性
 */
public class UnsharedConcreteFlyweight implements Flyweight{
    /**
     * 记录每个复合对象所包含的子组件
     */
    private List<Flyweight> list = new ArrayList<Flyweight>();

    /**
     * 组合对象要想相等，所有的子对象要都相等
     * @param securityEntity 安全实体
     * @param permit 权限
     * @return
     */
    @Override
    public boolean match(String securityEntity, String permit) {
        for (Flyweight f:list){
            //递归调用
            if (f.match(securityEntity,permit)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Flyweight f) {
        list.add(f);
    }
}

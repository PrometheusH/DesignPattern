package com.zjh.designpatterns.composite.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 组和对象：存储子对象，定义子部件的部件行为
 */
public class Composite extends Component{
    /**
     * 用来存储组合对象中包含的子组件对象
     */
    private List<Component> childComponent = null;


    /**
     * 示意方法，通常在里面实现递归的调用
     */
    @Override
    public void someOperation() {
        if (childComponent !=null){
            for (Component c:childComponent){
                c.someOperation();
            }
        }
    }

    @Override
    public void addChild(Component child) {
        //延迟初始化
        if (childComponent ==null){
            childComponent = new ArrayList<Component>();
        }
        childComponent.add(child);
    }

    @Override
    public void removeChild(Component child) {
        if (childComponent!=null){
            childComponent.remove(child);
        }
    }

    @Override
    public Component getChildren(int index) {
        if (childComponent!=null){
            if (index>0&&index<childComponent.size()){
                return childComponent.get(index);
            }
        }
        return null;
    }
}

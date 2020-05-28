package com.zjh.designpatterns.composite.concrete;

import java.util.ArrayList;
import java.util.List;

/**
 * 组和对象：存储子对象，定义子部件的部件行为
 */
public class Composite extends Component {
    /**
     * 用来存储组合对象中包含的子组件对象
     */
    private List<Component> childComponents = null;

    private String name = "";

    public Composite(String name) {
        this.name = name;
    }

    /**
     * 示意方法，通常在里面实现递归的调用
     */
    @Override
    public void printStruct(String preStr) {
        System.out.println(preStr + "+" + this.name);
        //如果还有子组件，就输出这些子组件对象
        if (this.childComponents != null) {
            //添加一个空格表示向后缩进一个空格
            preStr += " ";
            //输出当前对象的子对象
            for (Component c : childComponents) {
                //递归输出每个子对象
                c.printStruct(preStr);
            }
        }
    }

    @Override
    public void addChild(Component child) throws IllegalAccessException {
        //延迟初始化
        if (childComponents == null) {
            childComponents = new ArrayList<Component>();
        }
        childComponents.add(child);

        //添加对父组件的引用
        child.setParent(this);

        //判断组件路径是否为空
        if (this.getComponentPath() == null ||
                this.getComponentPath().trim().length() == 0) {
            //把本组件的name设置到组件路径中
            this.setComponentPath(this.name);
        }
        //判断要加入的组件在路径上是否出现过
        //先判断是否是根组件
        if (this.getComponentPath().startsWith(child.getName() + ".")) {
            //说明是根组件，重复添加了
            throw new IllegalAccessException("在本路径上，组件'" + child.getName() + "'已经被添加过了");
        } else {
            if (!this.getComponentPath().contains("." + child.getName())) {
                //表示没有出现过可以加入
                //计算组件的路径
                String componentPath = this.getComponentPath() + "." + child.getName();
                //设置子组件的路径，为什么呢？
                child.setComponentPath(componentPath);
            } else {
                throw new IllegalAccessException("在本路径上，组件'" + child.getName() + "'已经被添加过了");
            }
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Component> getChildren() {
        return childComponents;
    }

    @Override
    public void removeChild(Component child) {
        if (childComponents != null) {
            //查找要删除的组件在集合中的索引位置
            int idx = childComponents.indexOf(child);
            if (idx != -1) {
                //被删除的商品类别的 所有子类别的 父商品类别 设置成 被删除的商品类别的 父商品类别
                for (Component c : child.getChildren()) {
                    //child的子组件的父节点不再是child了，设置成了上一节点，也就是当前这个实例
                    c.setParent(this);
                    //既然设置了上一步，必然要真正的把child的子组件都加进自己的子组件列表中
                    childComponents.add(c);
                }
                //该实例真正删除child节点
                childComponents.remove(idx);
            }
        }
        //移除的时候也要更改componentPath呀！

    }


}

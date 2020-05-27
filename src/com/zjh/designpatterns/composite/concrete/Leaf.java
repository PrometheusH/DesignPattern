package com.zjh.designpatterns.composite.concrete;

/**
 * 叶子对象不再包含其他子对象
 */
public class Leaf extends Component {

    private String name ="";
    public Leaf(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * 叶子对象可能有自己的功能方法
     */
    @Override
    public void printStruct(String preStr) {
        System.out.println(preStr+"-"+name);
    }
}

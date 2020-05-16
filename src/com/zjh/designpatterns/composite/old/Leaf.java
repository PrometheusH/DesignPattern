package com.zjh.designpatterns.composite.old;

/**
 * 叶子对象
 */
public class Leaf {
    /**
     * 叶子对象的名称
     */
    private String name = "";

    public Leaf(String name) {
        this.name = name;
    }

    /**
     * 输出叶子对象的结构，叶子对象没有子对象，也就是输出叶子对象的名字
     * @param preStr
     */
    public void printStruct(String preStr){
        System.out.println(preStr+"-"+name);
    }

}

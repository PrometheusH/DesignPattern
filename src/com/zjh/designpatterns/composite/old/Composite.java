package com.zjh.designpatterns.composite.old;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 组合对象：可以包含其他组合对象和叶子对象
 */
public class Composite {
    /**
     * 用来记录包含其他组合对象
     */
    private Collection<Composite> childComposite = new ArrayList<Composite>();

    /**
     * 用来记录包含其他叶子对象
     */
    private Collection<Leaf> childLeaf = new ArrayList<Leaf>();

    /**
     * 组合对象的名字
     */
    private String name = "";

    public Composite(String name) {
        this.name = name;
    }

    /**
     * 向组合对象中加入被它包含的其他组合对象
     * @param c
     */
    public void addComposite(Composite c){
        this.childComposite.add(c);
    }

    /**
     * 向组合对象中加入被它包含的其他叶子对象
     * @param leaf
     */
    public void addLeaf(Leaf leaf){
        this.childLeaf.add(leaf);
    }

    /**
     * 输出自身对象的结构
     * @param preStr 前缀，主要是按层级拼接的空格，输出自己包含的叶子对象
     */
    public void printStruct(String preStr){
        //先把自己输出出去
        System.out.println(preStr+"+"+this.name);

        //然后添加一个空格表示向后缩进一个空格
        preStr+=" ";

        for (Leaf leaf:childLeaf){
            leaf.printStruct(preStr);
        }
        //输出当前对象的子对象了
        for (Composite c :childComposite){
            //递归输出每个子对象
            c.printStruct(preStr);
        }

    }
}

package com.zjh.designpatterns.Iterator.model;

public class Client {
    public static void main(String[] args) {
        String[] names = {"张三","李四","王五"};
        Aggregate aggregate = new ConcreteAggregate(names);
        Iterator iterator = aggregate.createIterator();
        iterator.first();
        while (!iterator.isDone()){
            Object obj = iterator.currentItem();
            System.out.println("the obj="+obj);
            iterator.next();
        }
    }
}

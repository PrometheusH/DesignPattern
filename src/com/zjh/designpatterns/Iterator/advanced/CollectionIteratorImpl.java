package com.zjh.designpatterns.Iterator.advanced;

import java.util.Iterator;

public class CollectionIteratorImpl implements Iterator {
    private PayManager aggregate=null;
    private int index= 0;

    public CollectionIteratorImpl(PayManager aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public boolean hasNext() {
        if (aggregate!=null&&index<aggregate.size())
            return true;
        return false;
    }

    @Override
    public Object next() {
        Object retObj = null;
        if (hasNext()){
            retObj = aggregate.get(index);
            index++;
        }
        return retObj;
    }
}

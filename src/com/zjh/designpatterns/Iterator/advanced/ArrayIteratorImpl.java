package com.zjh.designpatterns.Iterator.advanced;

import java.util.Iterator;

public class ArrayIteratorImpl implements Iterator {
    private SalaryManager aggregate = null;
    private int index = 0;

    public ArrayIteratorImpl(SalaryManager aggregate) {
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
        Object obj = null;
        if (hasNext()){
            obj = aggregate.get(index);
            index++;
        }
        return obj;
    }
}

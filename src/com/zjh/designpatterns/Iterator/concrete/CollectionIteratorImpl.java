package com.zjh.designpatterns.Iterator.concrete;

public class CollectionIteratorImpl implements Iterator{
    private PayManager aggregate=null;
    private int index= -1;

    public CollectionIteratorImpl(PayManager aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void next() {
        index++;
    }

    @Override
    public boolean isDone() {
        if (index==aggregate.size())
            return true;
        return false;
    }

    @Override
    public Object currentItem() {

        return aggregate.get(index);
    }
}

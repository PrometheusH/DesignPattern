package com.zjh.designpatterns.strategy.model;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public void contextInterface(){
        strategy.algorithmInterface();
    }
}

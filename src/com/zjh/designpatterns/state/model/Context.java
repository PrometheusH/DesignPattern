package com.zjh.designpatterns.state.model;

public class Context {
    State state;

    public Context(State state) {
        this.state = state;
    }
    public void request(String sampleParameter){
        state.handle(sampleParameter);
    }
}

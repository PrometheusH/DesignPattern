package com.zjh.designpatterns.abstact_factory.concrete;

public class Schema2 implements AbstractFactory{
    @Override
    public CPUApi createCPUApi() {
        return new AMDCPU(939);
    }

    @Override
    public MainboardApi createMainboardApi() {
        return new MSIMainboard(939);
    }
}

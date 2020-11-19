package com.zjh.designpatterns.abstact_factory.concrete;

public interface AbstractFactory {
    CPUApi createCPUApi();
    MainboardApi createMainboardApi();
}

package com.zjh.designpatterns.abstact_factory.concrete;

public class IntelCPU implements CPUApi {
    private int pins = 0;

    public IntelCPU(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculte() {
        System.out.println("现在是IntelCPU，针脚为："+pins);
    }
}

package com.zjh.designpatterns.abstact_factory.concrete;

public class AMDCPU implements CPUApi {
    private int pins=0;

    public AMDCPU(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculte() {
        System.out.println("现在是AMD CPU，针脚数目："+pins);
    }
}

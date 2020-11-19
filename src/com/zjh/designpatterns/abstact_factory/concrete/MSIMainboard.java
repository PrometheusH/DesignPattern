package com.zjh.designpatterns.abstact_factory.concrete;

public class MSIMainboard implements MainboardApi {
    private int cpuHoles = 0;

    public MSIMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("现在是微星主板，插槽孔数为："+cpuHoles);
    }
}

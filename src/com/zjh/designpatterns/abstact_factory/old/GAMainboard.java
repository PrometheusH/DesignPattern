package com.zjh.designpatterns.abstact_factory.old;

public class GAMainboard  implements MainboardApi{
    private int cpuHoles =0;

    public GAMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("现在是技嘉主板，插槽孔数为："+cpuHoles);
    }
}

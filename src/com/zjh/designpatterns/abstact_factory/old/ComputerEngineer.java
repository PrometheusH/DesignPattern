package com.zjh.designpatterns.abstact_factory.old;

import com.zjh.designpatterns.mediator.concrete.CPU;

public class ComputerEngineer {
    private CPUApi cpu=null;
    private MainboardApi mainboard = null;
    public  void makeComputer(int cpuType,int mainboardType){
        cpu = CPUFactory.createCPUApi(cpuType);
        mainboard = MainboardFactory.createMainboardApi(mainboardType);
        //测试一下是否好用
        this.cpu.calculte();
        this.mainboard.installCPU();
        //其他装机步骤
    }

}

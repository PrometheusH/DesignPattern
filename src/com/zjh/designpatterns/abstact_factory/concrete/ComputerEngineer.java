package com.zjh.designpatterns.abstact_factory.concrete;

public class ComputerEngineer {
    private CPUApi cpu=null;
    private MainboardApi mainboard = null;
    public  void makeComputer(AbstractFactory schema){
        cpu = schema.createCPUApi();
        mainboard = schema.createMainboardApi();
        cpu.calculte();
        mainboard.installCPU();
    }

}

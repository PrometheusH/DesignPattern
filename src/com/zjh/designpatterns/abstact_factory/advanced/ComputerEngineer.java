package com.zjh.designpatterns.abstact_factory.advanced;

public class ComputerEngineer {
    private CPUApi cpu=null;
    private MainboardApi mainboard = null;
    private MemoryApi memory = null;

    public  void makeComputer(AbstractFactory schema){
        cpu = (CPUApi) schema.createProduct(1);
        mainboard = (MainboardApi) schema.createProduct(2);
        memory = (MemoryApi) schema.createProduct(3);
        cpu.calculte();
        mainboard.installCPU();
        //为了同时满足以前的需求
        if (this.memory!=null){
            memory.cacheData();
        }
    }

}

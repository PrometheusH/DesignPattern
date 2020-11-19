package com.zjh.designpatterns.abstact_factory.old;

import com.zjh.designpatterns.mediator.concrete.CPU;

public class CPUFactory {
    public static CPUApi createCPUApi(int type){
        CPUApi api = null;
        if (type==1){
            api = new IntelCPU(1156);
        }else if (type==2){
            api = new AMDCPU(939);
        }
        return api;
    }
}

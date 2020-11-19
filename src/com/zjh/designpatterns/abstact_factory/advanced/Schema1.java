package com.zjh.designpatterns.abstact_factory.advanced;

public class Schema1 implements AbstractFactory {

    @Override
    public Object createProduct(int type) {
        Object retObj=null;
        if (type==1){
            retObj = new IntelCPU(1156);
        }else if (type==2){
            retObj = new GAMainboard(1156);
        }
        return retObj;
    }
}

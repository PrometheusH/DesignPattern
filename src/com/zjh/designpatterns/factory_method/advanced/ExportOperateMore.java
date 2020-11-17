package com.zjh.designpatterns.factory_method.advanced;

public class ExportOperateMore extends ExportOperate{
    protected ExportFileApi factoryMethod(int type) {
        ExportFileApi api = null;
        if(type==3){
            api = new ExportXml();
        }else {
            api = super.factoryMethod(type);
        }
        return api;
    }
}

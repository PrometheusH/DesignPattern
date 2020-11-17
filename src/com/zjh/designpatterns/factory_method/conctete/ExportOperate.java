package com.zjh.designpatterns.factory_method.conctete;

public abstract class ExportOperate {
    protected abstract ExportFileApi factoryMethod();
    public boolean export(String data){
        ExportFileApi api = factoryMethod();
        return api.export(data);
    }
}

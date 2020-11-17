package com.zjh.designpatterns.factory_method.advanced;

public class ExportOperate {
    protected  ExportFileApi factoryMethod(int type){
        ExportFileApi api = null;
        if (type==1){
            api = new ExportTxtFile();
        }else if (type==2){
            api = new ExportDB();
        }
        return api;
    }
    public boolean export(int type,String data){
        ExportFileApi api = factoryMethod(type);
        return api.export(data);
    }
}

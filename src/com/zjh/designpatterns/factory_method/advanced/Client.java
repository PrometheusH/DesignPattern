package com.zjh.designpatterns.factory_method.advanced;

public class Client {
    public static void main(String[] args) {
        ExportOperate exportOperate = new ExportOperateMore();
        exportOperate.export(1,"adada");
        exportOperate.export(3,"adada");
    }
}

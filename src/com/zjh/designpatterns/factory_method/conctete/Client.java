package com.zjh.designpatterns.factory_method.conctete;

public class Client {
    public static void main(String[] args) {
        ExportOperate exportOperate = new ExportDBOperate();
        exportOperate.export("aaa");
    }
}

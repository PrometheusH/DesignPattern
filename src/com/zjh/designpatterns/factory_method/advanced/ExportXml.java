package com.zjh.designpatterns.factory_method.advanced;

public class ExportXml implements ExportFileApi {
    @Override
    public boolean export(String data) {
        System.out.printf("数据导出为xml格式，存储路径为。。。");
        return true;
    }
}

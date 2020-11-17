package com.zjh.designpatterns.factory_method.advanced;
public class ExportDB implements ExportFileApi {
    @Override
    public boolean export(String data) {
        System.out.printf("导出数据为数据库文件，存储目录为。。。");
        return true;
    }
}

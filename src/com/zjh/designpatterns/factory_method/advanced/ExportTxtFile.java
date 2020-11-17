package com.zjh.designpatterns.factory_method.advanced;

public class ExportTxtFile implements ExportFileApi {
    @Override
    public boolean export(String data) {
        System.out.printf("已将数据导出为TXT文件，目录为。。。");
        return true;
    }
}

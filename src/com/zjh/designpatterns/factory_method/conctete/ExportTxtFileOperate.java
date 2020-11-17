package com.zjh.designpatterns.factory_method.conctete;

public class ExportTxtFileOperate extends ExportOperate{
    @Override
    protected ExportFileApi factoryMethod() {
        return new ExportTxtFile();
    }
}

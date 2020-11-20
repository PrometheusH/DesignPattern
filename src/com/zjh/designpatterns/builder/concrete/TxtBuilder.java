package com.zjh.designpatterns.builder.concrete;

import java.util.Collection;
import java.util.Map;

public class TxtBuilder implements Builder {
    StringBuffer buf = new StringBuffer();
    @Override
    public void builderHeader(ExportHeaderModel ehm) {
        buf.append(ehm.getDepId()+","+ehm.getExportDate()+"\n");
    }

    @Override
    public void builderData(Map<String, Collection<ExportDataModel>> mapData) {
        for (String tbName:mapData.keySet()){
            buf.append(tbName+"\n");
            for (ExportDataModel edm:mapData.get(tbName)){
                buf.append(edm.getProductId()+","+edm.getPrice()+","+edm.getAmount()+"\n");
            }
        }
    }

    @Override
    public void builderFooter(ExportFooterModel efm) {
        buf.append(efm.getExportUser());
    }

    @Override
    public void printFormatData(){
        System.out.println("输出文本文件的内容：\n"+buf);
    }
}

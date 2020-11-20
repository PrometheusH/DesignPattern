package com.zjh.designpatterns.builder.old;

import java.util.Collection;
import java.util.Map;

public class ExportToTxt {
    public void export(ExportHeaderModel ehm, Map<String, Collection<ExportDataModel>> mapData,ExportFooterModel efm){
        StringBuffer buf = new StringBuffer();
        buf.append(ehm.getDepId()+","+ehm.getExportDate()+"\n");
        for (String tbName:mapData.keySet()){
            buf.append(tbName+"\n");
            for (ExportDataModel edm:mapData.get(tbName)){
                buf.append(edm.getProductId()+","+edm.getPrice()+","+edm.getAmount()+"\n");
            }
            buf.append(efm.getExportUser());
            System.out.println("输出文本文件的内容：\n"+buf);
        }
    }
}

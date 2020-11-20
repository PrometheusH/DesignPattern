package com.zjh.designpatterns.builder.old;

import java.util.Collection;
import java.util.Map;

public class ExportToXml {
    public void export(ExportHeaderModel ehm, Map<String, Collection<ExportDataModel>> mapData,ExportFooterModel efm){
        StringBuffer buf = new StringBuffer();
        buf.append("<?xml version=1.0 encoding='gb2312'?>\n");
        buf.append("<Report>\n");
        buf.append("  <Header>\n");
        buf.append("    <DepId>"+ehm.getDepId()+"</DepId>\n");
        buf.append("    <ExportData>"+ehm.getExportDate()+"</ExportData>\n");
        buf.append("  </Header>\n");

        //拼接文件体
        buf.append("  <Body>\n");
        for (String tbName:mapData.keySet()){
            buf.append("  <Datas TableName=\""+tbName+"\">\n");
            for (ExportDataModel edm:mapData.get(tbName)){
                buf.append("    <Data>\n");
                buf.append("    <ProductId>"+edm.getProductId()+"</ProductId>\n");
                buf.append("    <Price>"+edm.getPrice()+"</Price>\n");
                buf.append("    <Amount>"+edm.getAmount()+"</Amount>\n");
                buf.append("    </Data>\n");
            }
            buf.append("    </Datas>\n");
        }
        buf.append("  </Body>\n");

        //拼接文件体
        buf.append("  <Footer>\n");
        buf.append("    <ExportUser>"+efm.getExportUser()+"</ExportUser>\n");
        buf.append("  </Footer>\n");
        buf.append("</Report>\n");

        System.out.println("输出Xml文件的内容：\n"+buf);
    }
}

package com.zjh.designpatterns.builder.concrete;

import java.util.Collection;
import java.util.Map;

public class XmlBuilder implements Builder {
    StringBuffer buf = new StringBuffer();

    @Override
    public void builderHeader(ExportHeaderModel ehm) {
        buf.append("<?xml version=1.0 encoding='gb2312'?>\n");
        buf.append("<Report>\n");
        buf.append("  <Header>\n");
        buf.append("    <DepId>" + ehm.getDepId() + "</DepId>\n");
        buf.append("    <ExportData>" + ehm.getExportDate() + "</ExportData>\n");
        buf.append("  </Header>\n");
    }

    @Override
    public void builderData(Map<String, Collection<ExportDataModel>> mapData) {
        buf.append("  <Body>\n");
        for (String tbName : mapData.keySet()) {
            buf.append("  <Datas TableName=\"" + tbName + "\">\n");
            for (ExportDataModel edm : mapData.get(tbName)) {
                buf.append("    <Data>\n");
                buf.append("    <ProductId>" + edm.getProductId() + "</ProductId>\n");
                buf.append("    <Price>" + edm.getPrice() + "</Price>\n");
                buf.append("    <Amount>" + edm.getAmount() + "</Amount>\n");
                buf.append("    </Data>\n");
            }
            buf.append("    </Datas>\n");
        }
        buf.append("  </Body>\n");
    }

    @Override
    public void builderFooter(ExportFooterModel efm) {
        buf.append("  <Footer>\n");
        buf.append("    <ExportUser>" + efm.getExportUser() + "</ExportUser>\n");
        buf.append("  </Footer>\n");
        buf.append("</Report>\n");
    }

    @Override
    public void printFormatData() {
        System.out.println("输出Xml文件的内容：\n" + buf);
    }
}

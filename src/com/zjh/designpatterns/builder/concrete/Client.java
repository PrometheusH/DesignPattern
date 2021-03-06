package com.zjh.designpatterns.builder.concrete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        ExportHeaderModel ehm = new ExportHeaderModel();
        ehm.setDepId("一分公司");
        ehm.setExportDate("2022-10-22");

        Map<String, Collection<ExportDataModel>> mapData = new HashMap<>();
        Collection<ExportDataModel> col = new ArrayList<>();
        ExportDataModel edm1 = new ExportDataModel();
        edm1.setProductId("产品001");
        edm1.setPrice(100);
        edm1.setAmount(80);
        col.add(edm1);

        ExportDataModel edm2 = new ExportDataModel();
        edm2.setProductId("产品002");
        edm2.setPrice(99);
        edm2.setAmount(55);
        col.add(edm2);

        mapData.put("销售记录表",col);

        ExportFooterModel efm = new ExportFooterModel();
        efm.setExportUser("张三");


        Builder txtBuilder = new TxtBuilder();
        Director director1 = new Director(txtBuilder);
        director1.construct(ehm,mapData,efm);

        Builder xmlBuilder = new XmlBuilder();
        Director director2 = new Director(xmlBuilder);
        director2.construct(ehm,mapData,efm);
    }
}

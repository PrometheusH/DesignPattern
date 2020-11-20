package com.zjh.designpatterns.builder.concrete;

import java.util.Collection;
import java.util.Map;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(ExportHeaderModel ehm
            , Map<String, Collection<ExportDataModel>> mapData
            ,ExportFooterModel efm){
        builder.builderHeader(ehm);
        builder.builderData(mapData);
        builder.builderFooter(efm);
        builder.printFormatData();
    }
}

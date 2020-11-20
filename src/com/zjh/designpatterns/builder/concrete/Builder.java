package com.zjh.designpatterns.builder.concrete;

import java.util.Collection;
import java.util.Map;

public interface Builder {
    void builderHeader(ExportHeaderModel ehm);
    void builderData(Map<String, Collection<ExportDataModel>> mapData);
    void builderFooter(ExportFooterModel efm);
    void printFormatData();
}

package com.zjh.designpatterns.facade.concrete;

/**
 * 示意生成逻辑层代码模块
 */
public class Business {
    public void genetate(){
        ConfigModel cm = ConfigManager.getInstance().getConfigData();
        if (cm.isNeedGenBusiness()){
            System.out.println("正在生成逻辑层代码");
        }
    }


}

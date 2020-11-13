package com.zjh.designpatterns.facade.old;

/**
 * 示意配置描述的数据Model，真实的配置数据会很多
 */
public class ConfigModel {
    /**
     * 是否需要生成表现层，这里应该是false，ConfigManager中通过set方法设置，但因为没弄配置文件，所以直接用true了。
     */
    private boolean needGenPresentation = true;
    /**
     * 是否需要生成逻辑层
     */
    private boolean needGenBusiness = true;
    /**
     * 是否需要生成DAO层
     */
    private boolean needGenDAO = true;

    public boolean isNeedGenPresentation() {
        return needGenPresentation;
    }

    public void setNeedGenPresentation(boolean needGenPresentation) {
        this.needGenPresentation = needGenPresentation;
    }

    public boolean isNeedGenBusiness() {
        return needGenBusiness;
    }

    public void setNeedGenBusiness(boolean needGenBusiness) {
        this.needGenBusiness = needGenBusiness;
    }

    public boolean isNeedGenDAO() {
        return needGenDAO;
    }

    public void setNeedGenDAO(boolean needGenDAO) {
        this.needGenDAO = needGenDAO;
    }
}

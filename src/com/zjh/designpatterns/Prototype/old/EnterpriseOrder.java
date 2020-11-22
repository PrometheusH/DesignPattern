package com.zjh.designpatterns.Prototype.old;

public class EnterpriseOrder implements OrderApi {
    private String enterpriseName;
    private String productId;
    private int productNum;
    @Override
    public int getOrderProductNum() {
        return this.productNum;
    }

    @Override
    public void setOrderProductNum(int num) {
        this.productNum = num;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "企业订单的订购企业是：" + enterpriseName + '\'' +
                "，订购产品是：'" + productId + '\'' +
                "，订购数量是：" + productNum +
                '}';
    }
}

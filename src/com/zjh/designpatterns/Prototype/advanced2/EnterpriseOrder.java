package com.zjh.designpatterns.Prototype.advanced2;

import com.zjh.designpatterns.builder.model.Product;

public class EnterpriseOrder implements OrderApi {
    private String enterpriseName;
    private ProductB productB;
    private int productNum;
    @Override
    public int getOrderProductNum() {
        return this.productNum;
    }

    @Override
    public void setOrderProductNum(int num) {
        this.productNum = num;
    }

    @Override
    public OrderApi clone() {
        EnterpriseOrder clonedOrder = new EnterpriseOrder();
        clonedOrder.setEnterpriseName(this.enterpriseName);
        clonedOrder.setOrderProductNum(this.productNum);
        clonedOrder.setProductB((ProductB) this.productB.cloneProduct());
        return clonedOrder;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public void setProductB(ProductB productB) {
        this.productB = productB;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    @Override
    public String toString() {
        return "EnterpriseOrder{" +
                "enterpriseName='" + enterpriseName + '\'' +
                ", productB=" + productB +
                ", productNum=" + productNum +
                '}';
    }
}

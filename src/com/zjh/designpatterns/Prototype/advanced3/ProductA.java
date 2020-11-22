package com.zjh.designpatterns.Prototype.advanced3;

public class ProductA implements Cloneable {
    private String productName;
    private String productId;

    public ProductA(String productName, String productId) {
        this.productName = productName;
        this.productId = productId;
    }

    public ProductA() {
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

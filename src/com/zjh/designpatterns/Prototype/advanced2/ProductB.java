package com.zjh.designpatterns.Prototype.advanced2;

public class ProductB implements ProductPrototype{
    private String productName;
    private String productId;

    public ProductB(String productName, String productId) {
        this.productName = productName;
        this.productId = productId;
    }

    public ProductB() {
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    //浅复制
    @Override
    public ProductPrototype cloneProduct() {
        ProductB p = new ProductB();
        p.setProductId(this.productId);
        p.setProductName(this.productName);
        return p;
    }
}

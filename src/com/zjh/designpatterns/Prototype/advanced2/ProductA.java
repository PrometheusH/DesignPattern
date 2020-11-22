package com.zjh.designpatterns.Prototype.advanced2;

import com.zjh.designpatterns.builder.model.Product;

public class ProductA implements ProductPrototype{
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

    //浅复制
    @Override
    public ProductPrototype cloneProduct() {
        ProductA p = new ProductA();
        p.setProductId(this.productId);
        p.setProductName(this.productName);
        return p;
    }
}

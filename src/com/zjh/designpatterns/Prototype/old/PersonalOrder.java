package com.zjh.designpatterns.Prototype.old;

public class PersonalOrder implements OrderApi{

    private String customerName;
    private String productId;
    private int productNum = 0;

    @Override
    public int getOrderProductNum() {
        return this.productNum;
    }

    @Override
    public void setOrderProductNum(int num) {
        this.productNum = num;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "本个人订单的订购人是：" +
                customerName + '\'' +
                "，订购产品是：" + productId + '\'' +
                "，订购数量是：" + productNum +
                '}';
    }
}

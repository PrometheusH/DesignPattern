package com.zjh.designpatterns.Prototype.advanced2;

public class PersonalOrder implements OrderApi {

    private String customerName;
    private ProductA productA;
    private int productNum = 0;

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
        PersonalOrder po = new PersonalOrder();
        po.setOrderProductNum(this.productNum);
        po.setProductA((ProductA) this.productA.cloneProduct());
        po.setCustomerName(this.customerName);
        return po;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setProductA(ProductA productA) {
        this.productA = productA;
    }

    @Override
    public String toString() {
        return "PersonalOrder{" +
                "customerName='" + customerName + '\'' +
                ", productA=" + productA +
                ", productNum=" + productNum +
                '}';
    }
}

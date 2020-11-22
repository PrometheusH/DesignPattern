package com.zjh.designpatterns.Prototype.advanced3;

public class PersonalOrder implements Cloneable {

    private String customerName;
    private ProductA productA;
    private int productNum = 0;

    public int getOrderProductNum() {
        return this.productNum;
    }

    public void setOrderProductNum(int num) {
        this.productNum = num;
    }

    @Override
    public Object clone() {
        PersonalOrder po = null;
        try {
            po = (PersonalOrder) super.clone();
            po.setProductA((ProductA)this.productA.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
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

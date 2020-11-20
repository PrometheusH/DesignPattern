package com.zjh.designpatterns.builder.advanced2;

import com.zjh.designpatterns.builder.advanced.ConcreteBuilder;

public class Client {
    public static void main(String[] args) {
        InsuranceContract.ConcretBuilder builder = new InsuranceContract.ConcretBuilder("001",213l,1234l);
        InsuranceContract insuranceContract = builder.setPersonName("张三").setOtherData("哦哈哈哈").build();
        insuranceContract.someOption();
    }
}

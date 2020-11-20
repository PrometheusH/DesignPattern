package com.zjh.designpatterns.builder.advanced;

public class Client {
    public static void main(String[] args) {
        ConcreteBuilder builder = new ConcreteBuilder("001",1223L,343223L);
        InsuranceContract contract = builder.setPersonName("周小二").setOtherData("哦哦这是OtherDate").build();
        contract.someOption();

    }
}

package com.zjh.designpatterns.abstact_factory.concrete;

public class Client {
    public static void main(String[] args) {
        ComputerEngineer engineer = new ComputerEngineer();
        AbstractFactory schema = new Schema2();
        engineer.makeComputer(schema);
    }
}

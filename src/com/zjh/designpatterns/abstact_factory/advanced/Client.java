package com.zjh.designpatterns.abstact_factory.advanced;

public class Client {
    public static void main(String[] args) {
        ComputerEngineer engineer = new ComputerEngineer();
        AbstractFactory schema = new Schema3();
        engineer.makeComputer(schema);
    }
}

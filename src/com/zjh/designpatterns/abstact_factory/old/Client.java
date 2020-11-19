package com.zjh.designpatterns.abstact_factory.old;

public class Client {
    public static void main(String[] args) {
        ComputerEngineer engineer = new ComputerEngineer();
        engineer.makeComputer(1,1);
    }
}

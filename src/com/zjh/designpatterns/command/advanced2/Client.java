package com.zjh.designpatterns.command.advanced2;

public class Client {
    public static void main(String[] args) {
        OperationApi operation = new Operation();
        AddCommand addCmd = new AddCommand(operation,5);
        SubstractCommand subCmd = new SubstractCommand(operation,3);

        Calculator calculator = new Calculator();
        calculator.setAddCommand(addCmd);
        calculator.setSubCommand(subCmd);

        calculator.addPressed();
        System.out.println("一次加法运算后的结果为："+operation.getResult());
        calculator.substractPressed();
        System.out.println("一次减法运算后的结果为："+operation.getResult());

        calculator.undoPressed();
        System.out.println("撤销一次的结果为："+operation.getResult());
        calculator.undoPressed();
        System.out.println("再撤销一次的结果为："+operation.getResult());

        calculator.redoPressed();
        System.out.println("恢复一次的结果为："+operation.getResult());
        calculator.redoPressed();
        System.out.println("再恢复一次的结果为："+operation.getResult());
    }
}

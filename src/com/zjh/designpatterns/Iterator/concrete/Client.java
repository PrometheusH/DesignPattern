package com.zjh.designpatterns.Iterator.concrete;


public class Client {
    public static void main(String[] args) {
        PayManager payManager = new PayManager();
        payManager.calcPay();
        System.out.println("集团工资列表：");
        test(payManager.createIterator());

        SalaryManager salaryManager = new SalaryManager();
        salaryManager.calcSalary();
        System.out.println("新收购的公司工资列表：");
        test(salaryManager.createIterator());
    }

    public static void test(Iterator it){
        it.first();
        while (!it.isDone()){
            Object obj = it.currentItem();
            System.out.println("the obj="+obj);
            it.next();
        }

    }
}

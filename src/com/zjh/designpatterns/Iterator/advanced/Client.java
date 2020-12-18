package com.zjh.designpatterns.Iterator.advanced;

import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        PayManager payManager = new PayManager();
        payManager.calcPay();
        System.out.println("集团工资列表：");
        test(new CollectionIteratorImpl(payManager));

        SalaryManager salaryManager = new SalaryManager();
        salaryManager.calcSalary();
        System.out.println("新收购的公司工资列表：");
        test(new ArrayIteratorImpl(salaryManager));
    }

    public static void test(Iterator it){
        while (it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }

    }
}

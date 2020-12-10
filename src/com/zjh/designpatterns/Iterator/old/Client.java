package com.zjh.designpatterns.Iterator.old;

import java.util.Collection;
import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        PayManager payManager = new PayManager();
        payManager.calcPay();
        Collection payList = payManager.getPayList();
        Iterator it = payList.iterator();
        System.out.println("集团工资列表：");
        while (it.hasNext()){
            PayModel pm = (PayModel) it.next();
            System.out.println(pm);
        }

        SalaryManager salaryManager = new SalaryManager();
        salaryManager.calcSalary();
        PayModel[] pms = salaryManager.getPays();
        System.out.println("新收购的公司工资列表：");
        for (int i=0;i<pms.length;i++){
            System.out.println(pms[i]);
        }
    }
}

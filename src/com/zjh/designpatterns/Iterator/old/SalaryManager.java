package com.zjh.designpatterns.Iterator.old;

public class SalaryManager {
    private PayModel[] pms =null;

    public PayModel[] getPays() {
        return pms;
    }

    public void calcSalary(){
        PayModel pm1 = new PayModel();
        pm1.setPay(3400);
        pm1.setUserName("王五");
        PayModel pm2 = new PayModel();
        pm2.setPay(7200);
        pm2.setUserName("赵六");

        pms = new PayModel[2];
        pms[0] = pm1;
        pms[1] = pm2;
    }

}

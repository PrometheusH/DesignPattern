package com.zjh.designpatterns.Iterator.concrete;

public class SalaryManager extends Aggregate{
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

    @Override
    public Iterator createIterator() {
        return new ArrayIteratorImpl(this);
    }


    public int size() {
        return pms.length;
    }


    public Object get(int index) {
        return pms[index];
    }
}

package com.zjh.designpatterns.Iterator.advanced;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PayManager{
    private List list = new ArrayList();

    public List getPayList(){
        return list;
    }

    /**
     * 给每个人计算工资，应该很复杂，这里简化了，并初始化
     */
    public void calcPay(){
        PayModel pm1 = new PayModel();
        pm1.setPay(2000);
        pm1.setUserName("张三");
        PayModel pm2 = new PayModel();
        pm2.setPay(5000);
        pm2.setUserName("李四");
        list.add(pm1);
        list.add(pm2);
    }

    public int size(){
        return list.size();
    }

    public Object get(int index){
        Object obj = null;
        if (index<=list.size()){
            obj=list.get(index);
        }
        return obj;

    }
}

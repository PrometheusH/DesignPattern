package com.zjh.designpatterns.command.advanced3;

public class CoolCook implements CookApi{
    @Override
    public void cook(String name) {
        System.out.println("厨师开始烹饪凉菜："+name+"到完成");
    }
}

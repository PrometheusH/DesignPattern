package com.zjh.designpatterns.command.advanced3;

public class HotCook implements CookApi{

    @Override
    public void cook(String name) {
        System.out.println("厨师正在烹饪热菜："+name);
    }
}

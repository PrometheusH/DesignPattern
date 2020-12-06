package com.zjh.designpatterns.command.advanced4;

public class Client {
    public static void main(String[] args) {
        CookManager.runCookManager();
        //每次循环是一个桌子点菜，一个菜单生成
        for (int i=0;i<5;i++){
            Waiter waiter = new Waiter();
            Command chop = new ChopCommand(i);
            Command duck = new DuckCommand(i);

            waiter.orderDish(chop);
            waiter.orderDish(duck);

            waiter.orderOver();
        }
    }
}

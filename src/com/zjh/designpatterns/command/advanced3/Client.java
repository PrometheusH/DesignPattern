package com.zjh.designpatterns.command.advanced3;

public class Client {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        Command chop = new ChopCommand();
        Command duck = new DuckCommand();
        Command huanggua = new HuangguaCommand();

        waiter.orderDish(chop);
        waiter.orderDish(duck);
        waiter.orderDish(huanggua);

        waiter.orderOver();
    }
}

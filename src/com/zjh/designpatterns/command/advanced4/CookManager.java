package com.zjh.designpatterns.command.advanced4;

public class CookManager {
    private static boolean runFlag = false;
    public static void runCookManager(){
        if (!runFlag){
            runFlag = true;
            //创建三位厨师
            HotCook cook1 = new HotCook("热菜厨师张三");
            HotCook cook2 = new HotCook("热菜厨师李四");
            HotCook cook3 = new HotCook("热菜厨师王五");

            Thread t1 = new Thread(cook1);
            t1.start();
            Thread t2 = new Thread(cook2);
            t2.start();
            Thread t3 = new Thread(cook3);
            t3.start();
        }
    }
}

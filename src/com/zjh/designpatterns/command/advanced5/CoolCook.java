package com.zjh.designpatterns.command.advanced5;

public class CoolCook implements CookApi,Runnable {
    //厨师姓名
    private String name;

    public CoolCook(String name) {
        this.name = name;
    }

    public CoolCook() {
    }

    @Override
    public void cook(int tableNum,String name) {
        int cookTime = (int)(20*Math.random());
        System.out.println("厨师正在为"+tableNum+"烹饪凉菜："+name);
        try {
            Thread.sleep(cookTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("厨师为"+tableNum+"烹饪凉菜："+name+"完成");
    }

    public void run(){
        while (true){
            Command cmd = CommandQueue.getOneCommand();
            if (cmd!=null){
                cmd.setCookApi(this);
                cmd.execute();
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

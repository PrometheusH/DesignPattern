package com.zjh.designpatterns.command.advanced;

public class GigaMainBoard implements MainBoardApi {

    @Override
    public void open() {
        System.out.println("技嘉主板正在开机，请稍后");
        System.out.println("接通电源...");
        System.out.println("设备检查...");
        System.out.println("装载系统...");
        System.out.println("机器正常运转起来...");
        System.out.println("机器已经正常打开，请操作...");
    }

    @Override
    public void reset() {
        System.out.println("技嘉主板正在执行重启操作，请稍后");
        System.out.println("机器已经正常打开，请操作...");
    }
}

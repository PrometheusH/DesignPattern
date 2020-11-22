package com.zjh.designpatterns.Prototype.advanced4;

public class Client {
    public static void main(String[] args) {
        try {
            Prototype p1 = new ConcretePrototype1();
            PrototypeManager.setPrototype("Prototype1",p1);
            Prototype p3 = PrototypeManager.getPrototype("Prototype1").clone();
            System.out.println("第一个实例："+p3);
            //有人动态地切换了实现
            Prototype p2 = new ConcretePrototype2();
            PrototypeManager.setPrototype("Prototype1",p2);
            //重新获取原型来创建对象
            Prototype p4 = PrototypeManager.getPrototype("Prototype1").clone();
            System.out.println("第二个实例："+p4);
            //有人注销了这个模型
            PrototypeManager.removePrototype("Prototype1");
            //再次获取来创建对象
            Prototype p5 = PrototypeManager.getPrototype("Prototype1").clone();
            p5.setName("王五");
            System.out.println("第三个实例："+p5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

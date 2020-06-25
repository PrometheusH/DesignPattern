package com.zjh.designpatterns.proxy.advanced;

public class Client {
    public static void main(String[] args) {
        //保护代理的静态代理实现
//        //张三先登录系统创建了一个订单
//        OrderApi order = new OrderProxy(new Order("设计模式",100,"张三"));
//        //李四想要修改就会报错
//        order.setOrderNum(123,"李四");
//        //输出order
//        System.out.println("李四修改后，订单记录没有变化："+order);
//        order.setOrderNum(123,"张三");
//        //再次输出order
//        System.out.println("张三修改后，订单记录："+order);


        //保护代理的动态代理实现：
        //张三先登录系统创建了一个订单
        Order order = new Order("设计模式",100,"张三");

        //创建一个动态代理
        DynamicProxy dynamicProxy = new DynamicProxy();
        //然后把订单和动态代理关联起来
        OrderApi orderApi = dynamicProxy.getProxyInterface(order);

        //以下就需要使用被代理过的接口来操作了

        //李四想要修改就会报错
        orderApi.setOrderNum(123,"李四");
        //输出order
        System.out.println("李四修改后，订单记录没有变化："+orderApi);
        orderApi.setOrderNum(123,"张三");
        //再次输出order
        System.out.println("张三修改后，订单记录："+orderApi);

    }
}

package com.zjh.designpatterns.flyweight.concrete;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂，通常实现为单例
 */
public class FlyweightFactory {
    private static FlyweightFactory factory = new FlyweightFactory();

    private FlyweightFactory(){

    }

    public static FlyweightFactory getInstance(){
        return factory;
    }

    /**
     * 缓存多个Flyweight对象
     */
    private Map<String,Flyweight> fsMap = new HashMap<String,Flyweight>();

    /**
     * 获取key对应的享元对象
     * @param key
     * @return
     */
    public Flyweight getFlyweight(String key){
        Flyweight f = fsMap.get(key);
        if (f==null){
            f = new AutorizationFlyweight(key);
            fsMap.put(key,f);
        }
        return f;
    }
}

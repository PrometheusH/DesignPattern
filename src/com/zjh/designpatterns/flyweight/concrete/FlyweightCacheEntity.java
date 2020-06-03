package com.zjh.designpatterns.flyweight.concrete;

/**
 * 测试类，将CacheConfModel换成了FlyweightCacheEntity给FlyweightFactoryVersionzjh使用
 */
public class FlyweightCacheEntity {
    //该对象的名字
    String name;
    //该名字对应的对象
    Flyweight flyweight;
    //共享对象的缓存配置
    /**
     * 缓存开始计时的时间
     */
    private long beginTime;
    /**
     * 缓存对象需要被永久存储，也就是不需要从缓存中删除
     */
    private boolean forever;
    //缓存对象被引用的次数
    int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Flyweight getFlyweight() {
        return flyweight;
    }

    public void setFlyweight(Flyweight flyweight) {
        this.flyweight = flyweight;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public boolean isForever() {
        return forever;
    }

    public void setForever(boolean forever) {
        this.forever = forever;
    }

    @Override
    public String toString() {
        return "FlyweightCacheEntity{" +

                ", flyweight=" + flyweight +
                ", beginTime=" + beginTime +

                ", forever=" + forever +
                ", count=" + count +
                '}';
    }
}

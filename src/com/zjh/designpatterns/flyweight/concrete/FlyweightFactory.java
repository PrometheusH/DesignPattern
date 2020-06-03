package com.zjh.designpatterns.flyweight.concrete;

import sun.misc.Cache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 享元工厂，通常实现为单例
 */
public class FlyweightFactory {
    private static FlyweightFactory factory = new FlyweightFactory();

    private FlyweightFactory(){
        //启动清除缓存值的线程
        Thread t = new ClearCache();
        t.start();
    }

    public static FlyweightFactory getInstance(){
        return factory;
    }

    /**
     * 缓存多个Flyweight对象
     */
    private Map<String,Flyweight> fsMap = new HashMap<String,Flyweight>();

    //zjh：那直接写一个类持有String Flyweight Chache，Integer这四个对象多好。

    /**
     *  用来缓存共享对象的缓存配置，key值和上面Map一样。
     */
    private Map<String,CacheConfModel> cacheConfMap = new HashMap<String,CacheConfModel>();
    /**
     * 用来记录缓存对象被引用的次数，key值跟上面一样
     */
    private Map<String,Integer> countMap = new HashMap<String,Integer>();

    //为了测试方便，设置为了默认保留6秒
    private final long  DURABLE_TIME = 6*1000l;

    /**
     * 获取某个享元被使用的次数
     * @param key
     * @return
     */
    public synchronized int getUseTimes(String key){
        Integer count = countMap.get(key);
        if (count==null){
            count=0;
        }
        return count;
    }

    /**
     * 获取key对应的享元对象
     * 因为会对享元的一些状态做出改变，所以需要同步，同时只能有一个进程能修改它
     * @param key
     * @return
     */
    public synchronized Flyweight getFlyweight(String key){
        Flyweight f = fsMap.get(key);
        if (f==null){
            f = new AutorizationFlyweight(key);
            fsMap.put(key,f);
            // 同时设置引用计数
            countMap.put(key,1);

            //同时设置缓存配置数据
            CacheConfModel cm = new CacheConfModel();
            cm.setBeginTime(System.currentTimeMillis());
            cm.setForever(false);
            cm.setDurableTime(DURABLE_TIME);

            cacheConfMap.put(key,cm);
        }else {
            //表示还在使用，应该重新设置缓存配置
            CacheConfModel cm = cacheConfMap.get(key);
            cm.setBeginTime(System.currentTimeMillis());
            //设置回去
            this.cacheConfMap.put(key,cm);
            //同时计数+1
            Integer count = countMap.get(key);
            count++;
            countMap.put(key,count);
        }
        return f;
    }

    /**
     * 删除key对应的享元对象，连带清除对应的缓存配置和引用次数的记录
     * @param key
     */
    private synchronized void removeFlyweight(String key){
        this.fsMap.remove(key);
        this.cacheConfMap.remove(key);
        this.countMap.remove(key);
    }

    /**
     * 维护清除缓存的线程
     */
    private class ClearCache extends Thread{
        public void run(){
            while (true){
                Set<String> tempSet = new HashSet<>();
                Set<String> set = cacheConfMap.keySet();
                for (String key:
                     set) {
                    //zjh：如果两个线程都在拿怎么办？
                    CacheConfModel ccm = cacheConfMap.get(key);
                    //比较是否需要清除
                    if ((System.currentTimeMillis()-ccm.getBeginTime())>=ccm.getDurableTime()){
                        //可以清除，先记录下来
                        tempSet.add(key);
                    }
                }
                //真正清除
                for (String key :
                        set) {
                    FlyweightFactory.getInstance().removeFlyweight(key);
                }
                System.out.println("now thread="+fsMap.size()+",fsMap=="+fsMap.keySet());

                try {
                    Thread.sleep(1000L);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

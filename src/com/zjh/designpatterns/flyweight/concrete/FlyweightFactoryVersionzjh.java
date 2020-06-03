package com.zjh.designpatterns.flyweight.concrete;

import java.util.*;

/**
 * 测试类
 * 我优化的享元工厂
 * 具体是将三个HashMap放到了一个类中
 *
 */
public class FlyweightFactoryVersionzjh {
    private static FlyweightFactoryVersionzjh factory = new FlyweightFactoryVersionzjh();

    private FlyweightFactoryVersionzjh(){
        //启动清除缓存值的线程
        Thread t = new ClearCache();
        t.start();
    }

    public static FlyweightFactoryVersionzjh getInstance(){
        return factory;
    }

//    /**
//     * 缓存多个Flyweight对象
//     */
//    private Map<String,Flyweight> fsMap = new HashMap<String,Flyweight>();
//
//    //zjh：那直接写一个类持有String Flyweight Chache，Integer这四个对象多好。
//
//    /**
//     *  用来缓存共享对象的缓存配置，key值和上面Map一样。
//     */
//    private Map<String,CacheConfModel> cacheConfMap = new HashMap<String,CacheConfModel>();
//    /**
//     * 用来记录缓存对象被引用的次数，key值跟上面一样
//     */
//    private Map<String,Integer> countMap = new HashMap<String,Integer>();

    private Map<String,FlyweightCacheEntity> cacheEntityMap = new HashMap<String,FlyweightCacheEntity>();

    //为了测试方便，设置为了默认保留6秒
    private final long  DURABLE_TIME = 6*1000l;

    /**
     * 获取某个享元被使用的次数
     * @param key
     * @return
     */
    public synchronized int getUseTimes(String key){
        Integer count = cacheEntityMap.get(key).getCount();
        if (count==null){
            count=0;
        }
        return count;
    }

    /**
     * 获取key对应的享元对象
     * 因为会对享元的一些状态做出改变，所以需要同步，同时只能有一个进程能修改它
     * 怎么把cacheEntityMap给锁住，在有使用这个Map的方法没有返回之前，任何方法不得使用这个Map？？？？
     * synchronized只是锁住方法？在一个线程调用这个方法的时候，别的线程不能调用这个方法，感觉没什么用，因为我其他线程又不调用这个方法。
     * 同一线程顺序执行，没有必要非要方法互斥使用同一元素
     * 而不同线程，我正从这个Map中取出了一个元素修改，拿出来想当于我引用了这个元素，我在更改这个元素，另一个线程也在更改这个元素，怎么办？currentHashMap?
     *
     *
     * @param key
     * @return
     */
    public synchronized Flyweight getFlyweight(String key){
        Flyweight f = cacheEntityMap.get(key).getFlyweight();
        if (f==null){
            f = new AutorizationFlyweight(key);
            FlyweightCacheEntity fce = new FlyweightCacheEntity();
            fce.setFlyweight(f);
            // 同时设置引用计数
            fce.setCount(1);
            //同时设置缓存配置数据
            fce.setBeginTime(System.currentTimeMillis());
            fce.setForever(false);

            cacheEntityMap.put(key,fce);
        }else {
            //表示还在使用，应该重新设置缓存配置
            FlyweightCacheEntity fce = cacheEntityMap.get(key);
            fce.setBeginTime(System.currentTimeMillis());
            //设置回去
            //同时计数+1
            Integer count = fce.getCount();
            count++;
            fce.setCount(count);
        }
        return f;
    }

    /**
     * 维护清除缓存的线程
     */
    private class ClearCache extends Thread{
        public void run(){
            while (true){
                //使用归并排序
                //将所有fover为false的拿出来，使用二分法进行优化，按照开始时间从小到大排序
                //如果中间的时间的当前时间-开始时间大于持续时间，将前面的全部删除并移除队列，low=low+mid，继续
                //否则high=high-mid，继续判断
                //直到。。。
                //以上以后再实现
                //现在直接从hashmap中查找也很快

                //这里表明FlyweightCacheEntity必须要有name属性，否则一旦从Map中只拿出values则找不到name了。
                Collection<FlyweightCacheEntity> fceColl = cacheEntityMap.values();
                Set<String> tset = new HashSet<>();
                for (FlyweightCacheEntity fce:
                     fceColl) {
                    if((System.currentTimeMillis()-fce.getBeginTime())>=DURABLE_TIME);
                    //为什么不直接通过name从cacheEntityMap中删除？直接this.cacheEntityMap.remove(key);不行吗？
                    //不行，因为这个类直接操作外面类的成员变量，做删除操作，不科学。但是上面cacheEntityMap都能直接操作了，为什么不行？
                    cacheEntityMap.remove(fce.getName());
                }

                try {
                    Thread.sleep(1000L);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

package com.zjh.designpatterns.flyweight.concrete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 安全管理实现成单例
 */
public class SecurityMgr {
    private static SecurityMgr securityMgr = new SecurityMgr();
    private SecurityMgr(){

    }
    public static SecurityMgr getInstance(){
        return securityMgr;
    }

    /**
     * 在运行期间，用来存放登陆人员对应的权限
     * 在web应用期间，这些数据通常会存放在session中
     */
    private Map<String, Collection<Flyweight>> map =
            new HashMap<String, Collection<Flyweight>>();

    /**
     * 模拟登陆的功能
     * @param user
     */
    public void login(String user){
        Collection<Flyweight> col = queryByUser(user);
        map.put(user,col);
    }

    /**
     * 判断某用户对某个安全实体是否拥有某种权限
     * @param user
     * @param securityEntity
     * @param permit
     * @return true 表示拥有相应的权限，false表示没有相应的权限
     */
    public boolean hasPermit(String user,String securityEntity,String permit){
        Collection<Flyweight> col = map.get(user);
        System.out.println("现在测试 "+securityEntity+" 的 "+permit+" 权限，map.size="+map.size());
        if(col==null||col.size()==0){
            System.out.println(user+"没有登陆或是没有被分配任何权限");
            return false;
        }
        for (Flyweight fm:col){
            //输出当前实例，看看是否是同一个实例对象
            System.out.println("fm=="+fm);
            if (fm.match(securityEntity,permit)){
                return true;
            }
        }
        return false;
    }

    /**
     * 从数据库中获取某人所拥有的权限
     * @param user
     * @return
     */
    public Collection<Flyweight> queryByUser(String user){
        Collection<Flyweight> col = new ArrayList<>();

        for (String s: TestDB.colDB){
            String[] ss = s.split(",");
            if (ss[0].equals(user)){
                Flyweight fw = null;
                if (ss[3].equals("2")){
                    //表示是组合
                    fw = new UnsharedConcreteFlyweight();
                    //通过查表，将该组合对象通过对象名字，查出来是由什么基本享元对象构成的，将这些基本享元对象缓存，并组装好这个组合对象返回，又是多态
                    String[] tempSs = TestDB.mapDB.get(ss[1]);
                    for (String ts:tempSs){
                        Flyweight tempFw = FlyweightFactory.getInstance().getFlyweight(ts);
                        //把这个对象加入到组合对象中
                        fw.add(tempFw);
                    }
                }else {
                    fw = FlyweightFactory.getInstance().getFlyweight(ss[1] + "," + ss[2]);
                    //zjh：也就是说相同的Flyweight，不会有多份。即使是不同的collection中的，
                    //只要是安全实体和权限相同的，就AutorizationFlyWeight只有一个，因为工厂中是相通《安全实体和权限》这个key，直接从工厂自己的Map中拿出的
                    //因为没有新new，而collection中保存的只是该对象的引用
                    //如《薪资数据，查看》这个就只有一个。
                }
                col.add(fw);
            }
        }
        return col;
    }
}

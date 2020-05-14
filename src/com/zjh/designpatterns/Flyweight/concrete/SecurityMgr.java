package com.zjh.designpatterns.Flyweight.concrete;

import com.zjh.designpatterns.Flyweight.old.TestDB;

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
        if(col==null||col.size()==0){
            System.out.println(user+"没有登陆或是没有被分配任何权限");
            return false;
        }
        for (Flyweight fm:col){
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
                Flyweight fm = FlyweightFactory.getInstance().getFlyweight(ss[1]+","+ss[2]);
                //zjh：也就是说相同的Flyweight，不会有多份。即使是不同的collection中的，
                //只要是安全实体和权限相同的，就AutorizationFlyWeight只有一个，因为工厂中是相通安全实体和权限的就直接从缓存中拿出
                //因为没有新new，而collection中保存的只是该对象的引用
                //如《薪资数据，查看》这个就只有一个，
                col.add(fm);
            }
        }
        return col;
    }
}

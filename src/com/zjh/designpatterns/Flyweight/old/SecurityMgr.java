package com.zjh.designpatterns.Flyweight.old;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 安全管理，实现成单例
 */
public class SecurityMgr {
    private SecurityMgr() {
    }
    private static SecurityMgr securityMgr = new SecurityMgr();
    public static SecurityMgr getInstance(){
        return securityMgr;
    }

    /**
     * 在运行期间存放登陆人员对应的权限
     * 在Web引用中，这些数据通常会存放在session中
     */
    private Map<String, Collection<AuthorizationModel>> map = new HashMap<String, Collection<AuthorizationModel>>();
    /**
     * 模拟登陆的功能
     */
    public void login(String user){
        //登陆时就应该把该用户所有的权限，从数据库中取出来，放到缓存中去
        Collection<AuthorizationModel> col = queryByUser(user);
        map.put(user,col);
    }

    private Collection<AuthorizationModel> queryByUser(String user) {
        Collection<AuthorizationModel> col = new ArrayList<AuthorizationModel>();
        for (String s:TestDB.colDB){
            String[] ss = s.split(",");
            if (ss[0].equals(user)){
                AuthorizationModel am = new AuthorizationModel();
                am.setUser(ss[0]);
                am.setSecurityEntity(ss[1]);
                am.setPermit(ss[2]);
                col.add(am);
            }
        }
        return col;
    }

    /**
     * 判断某用户对某个安全实体是否拥有某种权限
     */
    public boolean hasPermit(String user,String securityEnity,String permit){
        Collection<AuthorizationModel> col = map.get(user);
        if (col==null||col.size()==0){
            System.out.println(user+"没有登陆或是没有被分配任何权限");
            return false;
        }

        for (AuthorizationModel am:col){
            System.out.println("am==="+am);
            if (am.getSecurityEntity().equals(securityEnity)
            && am.getPermit().equals(permit)){
                return true;
            }
        }
        return false;
    }
}


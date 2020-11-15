package com.zjh.designpatterns.mediator.advanced;

import java.util.ArrayList;
import java.util.Collection;

public class DepUserMediatorImpl {
    private static DepUserMediatorImpl mediator = new DepUserMediatorImpl();
    private DepUserMediatorImpl(){
        initTestData();
    }
    public static DepUserMediatorImpl getInstance(){
        return mediator;
    }
    //测试用
    private Collection<DepUserModel> depUserCol = new ArrayList<DepUserModel>();
    //测试用
    private void initTestData(){
        DepUserModel dul = new DepUserModel();
        dul.setDepUserId("du1");
        dul.setDepId("d1");
        dul.setUserId("u1");
        depUserCol.add(dul);

        DepUserModel du2 = new DepUserModel();
        du2.setDepUserId("du2");
        du2.setDepId("d1");
        du2.setUserId("u2");
        depUserCol.add(du2);

        DepUserModel du3 = new DepUserModel();
        du3.setDepUserId("du3");
        du3.setDepId("d2");
        du3.setUserId("u3");
        depUserCol.add(du3);

        DepUserModel du4 = new DepUserModel();
        du4.setDepUserId("du4");
        du4.setDepId("d2");
        du4.setUserId("u4");
        depUserCol.add(du4);

        DepUserModel du5 = new DepUserModel();
        du5.setDepUserId("du5");
        du5.setDepId("d2");
        du5.setUserId("u1");
        depUserCol.add(du5);
    }

    public boolean deleteDep(String depId){
        Collection<DepUserModel> tmpCol = new ArrayList<DepUserModel>();
        for (DepUserModel dum:depUserCol){
            if (dum.getDepId().equals(depId)) tmpCol.add(dum);
        }
        depUserCol.removeAll(tmpCol);
        return true;
    }

    public boolean deleteUser(String userId){
        Collection<DepUserModel> tmpCol = new ArrayList<DepUserModel>();
        for (DepUserModel dum:depUserCol){
            if(dum.getUserId().equals(userId)) tmpCol.add(dum);
        }
        depUserCol.removeAll(tmpCol);
        return true;
    }

    public void showDepUsers(Dep dep){
        for (DepUserModel dum:depUserCol){
            if (dum.getDepId().equals(dep.getDepId()))
                System.out.println("部门编号："+dep.getDepId()+"，拥有人员编号："+dum.getUserId());
        }
    }

    public void showUserDeps(User user){
        for (DepUserModel dum:depUserCol){
            if (dum.getUserId().equals(user.getUserId()))
                System.out.println("人员编号："+user.getUserId()+"，所在部门编号："+dum.getDepId());
        }
    }

    //暂时不去实现
    public boolean changeDep(String userId,String oldDepId,String newDepId){
        return false;
    }

    //部门合并暂时不去实现了
    public boolean joinDep(Collection<String> depIds,Dep newDep){
        return false;
    }


}

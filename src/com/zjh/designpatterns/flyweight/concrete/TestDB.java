package com.zjh.designpatterns.flyweight.concrete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 供测试用，在内存中模拟数据库的值
 */
public class TestDB {
    //用来存放授权数据的值
    public static Collection<String> colDB=new ArrayList<String>();

    //用来存放组合授权数据的值
    public static Map<String,String[]> mapDB = new HashMap<String,String[]>();

    static {
        //通过静态块来填充模拟的数据
        colDB.add("张三,人员列表,查看,1");
        colDB.add("李四,人员列表,查看,1");
        //数据库表中的组合对象：数据实体+权限，占据了数据实体的位置，权限位置为空
        colDB.add("李四,操作薪资数据,,2");

        mapDB.put("操作薪资数据",new String[]{"薪资数据,查看","薪资数据,修改"});


        //增加更过的授权数据
        for (int i=0;i<3;i++){
            colDB.add("张三"+i+",测试数据,查看,1");
        }
    }
}

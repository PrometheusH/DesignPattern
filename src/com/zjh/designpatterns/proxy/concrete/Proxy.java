package com.zjh.designpatterns.proxy.concrete;

import java.sql.*;

public class Proxy implements UserModelApi {
    /**
     * 持有被代理的具体的目标对象
     */
    private UserModel realSubject = null;

    /**
     * 构造方法，传入被代理的目标对象
     * @param realSubject
     */
    public Proxy(UserModel realSubject) {
        this.realSubject = realSubject;
    }

    /**
     * 标示是否已经重新装载过数据了
     */
    private boolean loaded = false;

    @Override
    public String getUserId() {
        return realSubject.getUserId();
    }

    @Override
    public void setUserId(String userId) {
        this.realSubject.setUserId(userId);
    }

    @Override
    public String getName() {
        return realSubject.getName();
    }

    @Override
    public void setName(String name) {
        this.realSubject.setName(name);
    }

    @Override
    public String getDepName() {
        return realSubject.getDepName();
    }

    @Override
    public void setDepName(String depId) {
        this.realSubject.setDepName(depId);
    }

    @Override
    public String getSex() {
        if (!this.loaded){
            //从数据库中重新装载
            reload();
            //设置重新装载的标志为true
            this.loaded = true;
        }
        return realSubject.getSex();
    }

    @Override
    public void setSex(String sex) {
        this.realSubject.setSex(sex);
    }

    @Override
    public String toString() {
        return "userId=" + getUserId() +
                "name=" + getName() +
                "depId=" + getDepName() +
                "sex=" + getSex()+"\n";
    }

    /**
     * 重新查询数据库，以获取完整的用户数据
     */
    private void reload(){
        System.out.println("重新查询数据库获取完整的用户数据，userId=="+realSubject.getUserId());
        Connection conn = null;

        try {
            conn = this.getConnection();
            String sql = "select * from user where user_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,realSubject.getUserId());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                //只需要重新获取除了user_id和name以外的数据
                realSubject.setSex(rs.getString("sex"));
            }
            rs.close();
            pstmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://192.168.225.15:3306/company?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","123456"
        );
    }
}

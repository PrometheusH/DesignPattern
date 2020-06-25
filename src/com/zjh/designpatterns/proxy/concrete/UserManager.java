package com.zjh.designpatterns.proxy.concrete;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 */
public class UserManager {
    /**
     * 根据部门编号来获取部门下的所有人员
     *
     * @param depId
     * @return
     * @throws Exception
     */
    public Collection<UserModelApi> getUserByDepId(String depId) throws Exception {
        Collection<UserModelApi> col = new ArrayList<UserModelApi>();
        Connection conn = null;
        try {
            conn = this.getConnection();
            //只需要查询user_id和name,depName三个值就可以了
            String sql = "select u.user_id,u.name uname,d.name dname from user u,dep d "
                    + "where u.dep_id=d.dep_id and d.dep_id like ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, depId + "%");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                //这里创建的是代理对象，而不是直接创建UserModel对象
                Proxy proxy = new Proxy(new UserModel());
                //只是设置userId和Name
                proxy.setUserId(rs.getString("user_id"));
                proxy.setName(rs.getString("uname"));
                proxy.setDepName(rs.getString("dname"));

                col.add(proxy);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

        return col;
    }

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://192.168.225.15:3306/company?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "123456"
        );
    }

}

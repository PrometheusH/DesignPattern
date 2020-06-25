package com.zjh.designpatterns.proxy.old;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
public class UserManager {
    /**
     * 根据部门编号来获取部门下的所有人员
     * @param depId
     * @return
     * @throws Exception
     */
    public Collection<UserModel> getUserByDepId(String depId) throws Exception{
        Collection<UserModel> col = new ArrayList<UserModel>();
        Connection conn =null;
        try {
            conn = this.getConnection();
            String sql = "select * from user u,dep d "
                    +"where u.dep_id=d.dep_id and d.dep_id like ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,depId+"%");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                UserModel um = new UserModel();
                um.setUserId(rs.getString("user_id"));
                um.setName(rs.getString("name"));
                um.setDepId(rs.getString("dep_id"));
                um.setSex(rs.getString("sex"));
                col.add(um);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }

        return col;
    }

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://192.168.225.15:3306/company","root","123456"
        );
    }
}

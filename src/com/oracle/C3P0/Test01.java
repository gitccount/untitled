package com.oracle.C3P0;

import java.sql.Connection;
import java.sql.SQLException;

public class Test01 {
    public static void main(String[] args) {
        int uid;
        String num = "20", price = "56.98";
        DBUtil_BO dbBo = new DBUtil_BO();
        DBUtils dbUtils = new DBUtils();
        dbBo.conn = C3p0Utils.getConnection();//取用一个连接
        String sql = "select * from product where num=? and price=?";
        try {
            dbBo.st = dbBo.conn.prepareStatement(sql);//预处理sql语句
            dbBo.st.setString(1, num);
            dbBo.st.setString(2, price);
//此时dbBo对象已经封装了一个数据库连接以及要执行的操作

            dbUtils.executeQuery(dbBo);//通过数据库操作类来执行这个操作封装类，结果封装回这个操作封装类

//从dbBo类提取操作结果
            if (dbBo.rs.next()) {
                uid = dbBo.rs.getInt("id");
                System.out.println("获得编号" + uid);
            }
//结果集遍历完了，手动释放连接回连接池
            dbUtils.realseSource(dbBo);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

package com.oracle.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3p0Utils {
    private static final String TAG = "C3p0Utils";
    static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(C3p0Utils.class.getName());

    //通过标识名来创建相应连接池
    static ComboPooledDataSource dataSource = new ComboPooledDataSource("RUNOOB");

    //从连接池中取用一个连接
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();

        } catch (Exception e) {
            logger.error("Exception in C3p0Utils!", e);
            throw new MyException("数据库连接出错!", e);
        }
    }

    //释放连接回连接池
    public static void close(Connection conn, PreparedStatement pst, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                logger.error("Exception in C3p0Utils!", e);
                throw new MyException("数据库连接关闭出错!", e);
            }
        }
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                logger.error("Exception in C3p0Utils!", e);
                throw new MyException("数据库连接关闭出错!", e);
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("Exception in C3p0Utils!", e);
                throw new MyException("数据库连接关闭出错!", e);
            }
        }
    }
}

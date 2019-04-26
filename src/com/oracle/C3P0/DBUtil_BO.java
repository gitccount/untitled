package com.oracle.C3P0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil_BO {
    public Connection conn = null;
    public PreparedStatement st = null;
    public ResultSet rs = null;

    public DBUtil_BO() {
        super();
    }
}

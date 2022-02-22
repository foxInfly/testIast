package com.lp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class jdbcdemo {

    //create table mytest(key varchar2(2000),value varchar2(2000));

    public static final String ORACLE_DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";

    public static void main(String[] args) {
        System.out.println("hello jdbc");

        final Connection conn = getConn(false);
        //selectDemo("select * from mytest");
        //insertDemo(conn,10000,1000);
        //selectDemo("select * from mytest");
            /*
            new Thread(){public void run()
                {
                    try {
                        insertDemo(conn,100,10);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }}.start();
                
            new Thread(){public void run()
                {
                    try {
                        insertDemo(conn,100,10);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }}.start();
                */
        new Thread() {
            public void run() {
                try {
                    selectDemo(conn, "select * from mytest");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static Connection getConn(boolean autoCommit) {
        Connection conn = null;
        try {
            Class.forName(ORACLE_DRIVER_CLASS);
            //two method , use thin(pure java not need oracle client installed)
            //or oci(need oracle client installed)
            conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.99.105:1521:xe","system","student");
            conn.setAutoCommit(autoCommit);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    static void selectDemo(Connection conn, String sql) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        rs.setFetchSize(1);//it is useful to set this value when the resultset is very large
        ResultSetMetaData rsmd = rs.getMetaData();
        for (int index = 1; index <= rsmd.getColumnCount(); index++)
            System.out.print(rsmd.getColumnName(index) + "\t");
        System.out.println();
        while (rs.next()) {
            for (int index = 1; index <= rsmd.getColumnCount(); index++)
                System.out.print(rs.getString(index) + "\t");
            System.out.println();
        }
    }

    static void insertDemo(Connection conn, int rowcount, int batchcount) throws SQLException {
        String sql = "insert into mytest(key,value) values(?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        for (int i = 1; i <= rowcount; i++) {
            stmt.setString(1, "Key" + i);
            stmt.setString(2, "Value" + i + " " + Thread.currentThread().getName());
            stmt.addBatch();
            if (i % batchcount == 0)
                stmt.executeBatch();
        }
        stmt.executeBatch();
    }

}
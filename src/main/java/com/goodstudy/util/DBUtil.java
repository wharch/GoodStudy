package com.goodstudy.util;

import com.sun.rowset.CachedRowSetImpl;

import javax.sql.rowset.CachedRowSet;
import java.sql.*;
import java.util.List;

public class DBUtil {
    public static void closeAll(ResultSet rs, PreparedStatement ps,Connection conn){
        try {
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/good_study?useUnicode=true&characterEncoding=utf-8";
            String user = "root";
            String password = "111111";
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static int doUpdate(String sql,Object...params){
        Connection conn = null;
        PreparedStatement ps = null;
        int n = 0;
        conn = getConnection();
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1,params[i]);
            }
            n = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(null,ps,conn);
        }
        return n;
    }
    public static ResultSet doQuery(String sql,Object...params){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CachedRowSet crs = null;
        conn = getConnection();
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1,params[i]);
            }
            rs = ps.executeQuery();
            crs = new CachedRowSetImpl();
            crs.populate(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(rs,ps,conn);
        }
        return crs;
    }

    public static Page doQueryByPage(String sql,int currrentPage, int pageSize,Object...params){
        String newsql = "select count(1) from (" + sql + ")  as t";
        ResultSet rs = doQuery(newsql, params);
        int totalCount = 0;
        try {
            if (rs.next()){
                totalCount = rs.getInt("count(1)");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            closeAll(rs,null,null);
        }
        if (currrentPage < 1) {
            currrentPage = 1;
        }

        //起始位置的值
        int start = (currrentPage - 1) * pageSize;
        //拼接分页的sql语句
        sql = sql + " limit " + start + "," + pageSize;

        Page page = new Page(currrentPage,pageSize,totalCount,doQuery(sql,params));

       return page;

    }
}

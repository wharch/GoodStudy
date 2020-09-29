package com.goodstudy.util;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    private static final String url = "jdbc:mysql://localhost:3306/test2?useUnicode=true&characterEncoding=utf-8";
    private static final String user = "root";
    private static final String password = "111111";

    /**
     * 创建连接对象
     *
     * @return Connection 对象
     */
    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;

    }

    /**
     *
     * @param sql
     *            插入删除修改查询语句
     * @param params
     *            可变数组
     * @return 受影响的行数
     */
    public static int exUpdate(String sql, Object... params) {
        Connection conne = getConn();
        PreparedStatement statement = null;
        int n = 0;
        try {
            statement = conne.prepareStatement(sql);
            // 由于?的个数不确定
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    statement.setObject(i + 1, params[i]);
                }
            }
            n = statement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conne.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return n;
    }

    public static Object exQuery(String sql, Class cla, Object... params) {
        List<Object> list = new ArrayList<Object>();
        Connection conne = getConn();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = conne.prepareStatement(sql);
            // 由于?的个数不确定
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    statement.setObject(i + 1, params[i]);
                }
            }
            rs = statement.executeQuery();
            //判断
            if ("java.lang.Object".equals(cla.getName())) {
                if (rs.next()) {
                    return rs.getInt(1);
                }

            }

            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();
            while (rs.next()) {
                Object object = cla.newInstance();
                for (int i = 1; i <= count; i++) {
                    String name = rsmd.getColumnLabel(i);
                    Object value = rs.getObject(i);
                    BeanUtils.copyProperty(object, name, value);
                }

                list.add(object);

            }
        } catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conne.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 分页的通用方法，mysql数据库 ，基础版
     *
     * @param sql
     * @param cla
     * @param page     页码
     * @param pageSize 每页显示的记录数
     * @param params
     * @return
     */
    public static Page exQueryByPage(String sql, Class cla, int page, int pageSize, Object... params) {
        // 问题:这里来加limit 还是传递过来之间就加好limit？
        // select .... from ... where ? ... limit ?,?
        //这里有一个sql 这个sql 查询总的记录数的   给表起别名  as t 别名
        String newsql = "select count(1) from (" + sql + ")  as t";
        // 如果传递的是object对象，查询操作得到就是单个结果
        int totalCount = (int) exQuery(newsql, Object.class, params);

        // 可以加page的判断
        if (page < 1) {
            page = 1;
        }

        //起始位置的值
        int start = (page - 1) * pageSize;
        //拼接分页的sql语句
        sql = sql + " limit " + start + "," + pageSize;

        // 页面展示的数据集
        List data = (List) exQuery(sql, cla, params);

        //这里给pageData赋值，确保一个页面上的数据是完整的.
        Page pageData = new Page(page, pageSize, totalCount, data);

        return pageData;
    }

    /**
     * 释放资源
     *
     * @param rs    结果集对象
     * @param pstmt 预处理对象
     * @param conn  连接对象
     */
    public static void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

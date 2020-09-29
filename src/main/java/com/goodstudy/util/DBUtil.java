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
     * 获取连接对象的方法
     *
     * @return java.sql.Connection对象
     */
    public static Connection getConn() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;

    }

    /**
     * 完成增加删除和修改的方法
     *
     * @param sql    insert update delete语句
     * @param params 可变数组
     * @return 受影响的行
     */
    public static int exUpdate(String sql, Object... params) {
        Connection conn = getConn();
        PreparedStatement pstmt = null;
        int n = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            // ?的个数不确定
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            // 打印pstmt对象
            System.out.println("pstmt:" + pstmt);
            // 4.执行sql,executeUpdate()返回的是受影响的行
            n = pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return n;
    }

    /**
     * 通用查询方法,返回值为list;
     *
     * @param sql    查询的sql语句
     * @param cls    Class类型的对象
     * @param params 占位符的参数列表
     * @return Object ->List<Object>
     */
    public static Object exQuery(String sql, Class cls, Object... params) {

        List<Object> list = new ArrayList<Object>();
        Connection conn = getConn();
        PreparedStatement pstmt = null;
        int n = 0;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(sql);
            // ?的个数不确定
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            // 打印pstmt对象
            System.out.println("pstmt:" + pstmt);
            // 4.执行sql,executeQuery()
            rs = pstmt.executeQuery();
            // 得到的是结果集Result 返回值"可能是" List集合
            // ResultSet-->List
            ResultSetMetaData rsmd = rs.getMetaData();
            // getColumnCount 得到查询的列有几个
            int count = rsmd.getColumnCount();
            System.out.println("count :" + count);
            // 遍历得到rs数据要使用rs.next
            while (rs.next()) {
                // 根据cls来创建指定类型的对象cls.newInstance(),实际的类型？
                Object bean = cls.newInstance();
                // 达到的目的是将列名和查询的结果依次取出来
                for (int i = 1; i <= count; i++) {
                    // 打印输出列名 和列的值
                    // System.out.println(rsmd.getColumnLabel(i) + "," + rsmd.getColumnName(i));
                    // System.out.println(rsmd.getColumnLabel(i) + "," + rs.getObject(i));
                    String name = rsmd.getColumnLabel(i);
                    Object value = rs.getObject(i);
                    // 急需一个工具，能将列名 + 列值->构造一个对选哪个出来
                    BeanUtils.copyProperty(bean, name, value);
                }
                // 要完成的事情是：构造一个对象出来，并添加到集合

                list.add(bean);
            }

        } catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            try {
                rs.close();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            try {
                pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }
}

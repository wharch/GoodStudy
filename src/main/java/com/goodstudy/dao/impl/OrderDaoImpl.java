package com.goodstudy.dao.impl;

import com.goodstudy.dao.OrderDao;
import com.goodstudy.domain.*;
import com.goodstudy.util.DBUtil;
import com.goodstudy.util.Page;
import com.goodstudy.util.RandomUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 作者:wh
 * 订单dao实现
 */
public class OrderDaoImpl implements OrderDao {
    /**
     * 查看所有订单
     * @return List<Order> 集合
     */
    @Override
    public List<Order> findAllOrder() {
        String sql = "select o.water_id,o.order_id,o.order_time,o.order_price,s.stu_name,s.stu_id,s.stu_email,c.* from order_info o inner join student s on o.stu_id = s.stu_id inner join course c on o.c_id = c.c_id";
        ResultSet rs = DBUtil.doQuery(sql);
        List<Order> orders = new ArrayList<>();
        try {
            while (rs.next()){
                int waterId = rs.getInt("water_id");
                String orderId = rs.getString("order_id");
                String orderTime = rs.getString("order_time");
                double orderPrice = rs.getDouble("order_price");
                String stuName = rs.getString("stu_name");
                int stuId = rs.getInt("stu_id");
                String stuEmail = rs.getString("stu_email");
                int cId = rs.getInt("c_id");
                String cName = rs.getString("c_name");
                int kindId = rs.getInt("kind_id");
                int tId = rs.getInt("t_id");
                String cMaster = rs.getString("c_master");
                String cInfo = rs.getString("c_info");
                double cPrice = rs.getDouble("c_price");
                int cStatus = rs.getInt("c_status");
                Student student = new Student(stuId,stuName,null,null,null,null,stuEmail,null);
                Course course = new Course(cId,cName,new Kind(kindId,null),new Teacher(tId,null,null,null,null,null,null,null,null,0,0,null,null),cMaster,cInfo,cPrice,cStatus);
                Order order = new Order(waterId,orderId,student,course,orderTime,orderPrice);
                orders.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orders;
    }

    /**
     * 分页 查看所有订单
     * @param currentPage 当前页
     * @param pageSize 一页显示多少记录
     * @return Page<Order> 对象
     */
    @Override
    public Page<Order> findAllOrderByPage(int currentPage, int pageSize) {
        String sql = "select o.water_id,o.order_id,o.order_time,o.order_price,s.stu_name,s.stu_id,s.stu_email,c.* from order_info o inner join student s on o.stu_id = s.stu_id inner join course c on o.c_id = c.c_id";
        Page<Order> page = DBUtil.doQueryByPage(sql, currentPage, pageSize);
        ResultSet rs = page.getRs();
        List<Order> orders = new ArrayList<>();
        try {
            while (rs.next()){
                int waterId = rs.getInt("water_id");
                String orderId = rs.getString("order_id");
                String orderTime = rs.getString("order_time");
                double orderPrice = rs.getDouble("order_price");
                String stuName = rs.getString("stu_name");
                int stuId = rs.getInt("stu_id");
                String stuEmail = rs.getString("stu_email");
                int cId = rs.getInt("c_id");
                String cName = rs.getString("c_name");
                int kindId = rs.getInt("kind_id");
                int tId = rs.getInt("t_id");
                String cMaster = rs.getString("c_master");
                String cInfo = rs.getString("c_info");
                double cPrice = rs.getDouble("c_price");
                int cStatus = rs.getInt("c_status");
                Student student = new Student(stuId,stuName,null,null,null,null,stuEmail,null);
                Course course = new Course(cId,cName,new Kind(kindId,null),new Teacher(tId,null,null,null,null,null,null,null,null,0,0,null,null),cMaster,cInfo,cPrice,cStatus);
                Order order = new Order(waterId,orderId,student,course,orderTime,orderPrice);
                orders.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        page.setData(orders);
        return page;
    }

    /**
     * 根据学生编号查询订单
     * @param stuId 学生编号
     * @return List<Order> 集合
     */
    @Override
    public List<Order> findAllOrderByStuId(int stuId) {
        String sql = "select o.water_id,o.order_id,o.order_time,o.order_price,s.stu_name,s.stu_id,s.stu_email,c.* from order_info o inner join student s on o.stu_id = s.stu_id inner join course c on o.c_id = c.c_id where o.stu_id = ?";
        ResultSet rs = DBUtil.doQuery(sql, stuId);
        List<Order> orders = new ArrayList<>();
        try {
            while (rs.next()){
                int waterId = rs.getInt("water_id");
                String orderId = rs.getString("order_id");
                String orderTime = rs.getString("order_time");
                double orderPrice = rs.getDouble("order_price");
                String stuName = rs.getString("stu_name");
                String stuEmail = rs.getString("stu_email");
                int cId = rs.getInt("c_id");
                String cName = rs.getString("c_name");
                int kindId = rs.getInt("kind_id");
                int tId = rs.getInt("t_id");
                String cMaster = rs.getString("c_master");
                String cInfo = rs.getString("c_info");
                double cPrice = rs.getDouble("c_price");
                int cStatus = rs.getInt("c_status");
                Student student = new Student(stuId,stuName,null,null,null,null,stuEmail,null);
                Course course = new Course(cId,cName,new Kind(kindId,null),new Teacher(tId,null,null,null,null,null,null,null,null,0,0,null,null),cMaster,cInfo,cPrice,cStatus);
                Order order = new Order(waterId,orderId,student,course,orderTime,orderPrice);
                orders.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orders;
    }

    /**
     * 分页 根据学生编号查看订单
     * @param currentPage 当前页
     * @param pageSize 一页显示多少记录
     * @param stuId 学生编号
     * @return Page<Order> 对象
     */
    @Override
    public Page<Order> findAllOrderByStuIdByPage(int currentPage, int pageSize, int stuId) {
        String sql = "select o.water_id,o.order_id,o.order_time,o.order_price,s.stu_name,s.stu_id,s.stu_email,c.* from order_info o inner join student s on o.stu_id = s.stu_id inner join course c on o.c_id = c.c_id where stu_id = ?";
        Page<Order> page = DBUtil.doQueryByPage(sql, currentPage, pageSize, stuId);
        ResultSet rs = page.getRs();
        List<Order> orders = new ArrayList<>();
        try {
            while (rs.next()){
                int waterId = rs.getInt("water_id");
                String orderId = rs.getString("order_id");
                String orderTime = rs.getString("order_time");
                double orderPrice = rs.getDouble("order_price");
                String stuName = rs.getString("stu_name");
                String stuEmail = rs.getString("stu_email");
                int cId = rs.getInt("c_id");
                String cName = rs.getString("c_name");
                int kindId = rs.getInt("kind_id");
                int tId = rs.getInt("t_id");
                String cMaster = rs.getString("c_master");
                String cInfo = rs.getString("c_info");
                double cPrice = rs.getDouble("c_price");
                int cStatus = rs.getInt("c_status");
                Student student = new Student(stuId,stuName,null,null,null,null,stuEmail,null);
                Course course = new Course(cId,cName,new Kind(kindId,null),new Teacher(tId,null,null,null,null,null,null,null,null,0,0,null,null),cMaster,cInfo,cPrice,cStatus);
                Order order = new Order(waterId,orderId,student,course,orderTime,orderPrice);
                orders.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        page.setData(orders);
        return page;
    }

    /**
     * 根据学生编号 课程编号查订单
     * @param stuId 学生编号
     * @param cId 课程编号
     * @return Order对象
     */
    @Override
    public Order findAllOrderByStuIdAndCId(int stuId, int cId) {
        String sql = "select o.water_id,o.order_id,o.order_time,o.order_price,s.stu_name,s.stu_id,s.stu_email,c.* from order_info o inner join student s on o.stu_id = s.stu_id inner join course c on o.c_id = c.c_id where o.stu_id = ? and o.c_id = ?";
        ResultSet rs = DBUtil.doQuery(sql, stuId, cId);
        Order order = null;
        try {
            if (rs.next()){
                int waterId = rs.getInt("water_id");
                String orderId = rs.getString("order_id");
                String orderTime = rs.getString("order_time");
                double orderPrice = rs.getDouble("order_price");
                String stuName = rs.getString("stu_name");
                String stuEmail = rs.getString("stu_email");
                String cName = rs.getString("c_name");
                int kindId = rs.getInt("kind_id");
                int tId = rs.getInt("t_id");
                String cMaster = rs.getString("c_master");
                String cInfo = rs.getString("c_info");
                double cPrice = rs.getDouble("c_price");
                int cStatus = rs.getInt("c_status");
                Student student = new Student(stuId,stuName,null,null,null,null,stuEmail,null);
                Course course = new Course(cId,cName,new Kind(kindId,null),new Teacher(tId,null,null,null,null,null,null,null,null,0,0,null,null),cMaster,cInfo,cPrice,cStatus);
                order = new Order(waterId,orderId,student,course,orderTime,orderPrice);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return order;
    }

    /**
     * 分页 根据学生编号 课程编号查订单
     * @param currentPage 当前页
     * @param pageSize 一页显示多少记录
     * @param stuId 学生编号
     * @param cId 课程编号
     * @return Page<Order> 对象
     */
    @Override
    public Page<Order> findAllOrderByStuIdAndCIdByPage(int currentPage, int pageSize, int stuId, int cId) {
        String sql = "select o.water_id,o.order_id,o.order_time,o.order_price,s.stu_name,s.stu_id,s.stu_email,c.* from order_info o inner join student s on o.stu_id = s.stu_id inner join course c on o.c_id = c.c_id where o.stu_id = ? and o.c_id = ?";
        Page<Order> page = DBUtil.doQueryByPage(sql, currentPage, pageSize, stuId, cId);
        ResultSet rs = page.getRs();
        List<Order> orders = new ArrayList<>();
        try {
            while (rs.next()){
                int waterId = rs.getInt("water_id");
                String orderId = rs.getString("order_id");
                String orderTime = rs.getString("order_time");
                double orderPrice = rs.getDouble("order_price");
                String stuName = rs.getString("stu_name");
                String stuEmail = rs.getString("stu_email");
                String cName = rs.getString("c_name");
                int kindId = rs.getInt("kind_id");
                int tId = rs.getInt("t_id");
                String cMaster = rs.getString("c_master");
                String cInfo = rs.getString("c_info");
                double cPrice = rs.getDouble("c_price");
                int cStatus = rs.getInt("c_status");
                Student student = new Student(stuId,stuName,null,null,null,null,stuEmail,null);
                Course course = new Course(cId,cName,new Kind(kindId,null),new Teacher(tId,null,null,null,null,null,null,null,null,0,0,null,null),cMaster,cInfo,cPrice,cStatus);
                Order order = new Order(waterId,orderId,student,course,orderTime,orderPrice);
                orders.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        page.setData(orders);
        return page;
    }

    /**
     * 添加订单
     * @param order 订单对象
     * @return 布尔
     */
    @Override
    public boolean addOrder(Order order) {
        String sql = "insert into order_info values(null,?,?,?,?,?)";
        return DBUtil.doUpdate(sql, RandomUtil.randomOrdeId(),order.getStudent().getStuId(),order.getCourse().getcId(),new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()),order.getOrderPrice())>0;
    }
}

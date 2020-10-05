package com.goodstudy.dao;

import com.goodstudy.domain.Order;
import com.goodstudy.util.Page;

import java.util.List;

/**
 * 作者:wh
 * 订单dao接口
 */
public interface OrderDao {
    //查看所有订单
    List<Order> findAllOrder();

    //分页 查看所有订单
    Page<Order> findAllOrderByPage(int currentPage, int pageSize);

    //根据学生编号查看所有订单
    List<Order> findAllOrderByStuId(int stuId);

    //分页 根据学生编号查看所有订单
    Page<Order> findAllOrderByStuIdByPage(int currentPage, int pageSize, int stuId);

    //根据学生编号和课程编号查询所有订单
    Order findAllOrderByStuIdAndCId(int stuId, int cId);

    //分页 根据学生编号和课程编号查看所有订单
    Page<Order> findAllOrderByStuIdAndCIdByPage(int currentPage, int pageSize, int stuId, int cId);

    //添加订单
    boolean addOrder(Order order);
}

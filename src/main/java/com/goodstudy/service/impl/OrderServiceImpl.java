package com.goodstudy.service.impl;

import com.goodstudy.dao.OrderDao;
import com.goodstudy.dao.impl.OrderDaoImpl;
import com.goodstudy.domain.Order;
import com.goodstudy.service.OrderService;
import com.goodstudy.util.Page;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao dao = new OrderDaoImpl();

    /**
     * 查看全部订单
     * @return  List<Order> 集合
     */
    @Override
    public List<Order> findAllOrder() {
        return dao.findAllOrder();
    }

    /**
     * 分页 查看所有订单
     * @param currentPage 当前页
     * @param pageSize 一页多少记录
     * @return Page<Order> 对象
     */
    @Override
    public Page<Order> findAllOrderByPage(int currentPage, int pageSize) {
        return dao.findAllOrderByPage(currentPage, pageSize);
    }

    /**
     * 根据学生编号查看订单
     * @param stuId 学生编号
     * @return List<Order>
     */
    @Override
    public List<Order> findAllOrderByStuId(int stuId) {
        return dao.findAllOrderByStuId(stuId);
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
        return dao.findAllOrderByStuIdByPage(currentPage, pageSize, stuId);
    }

    /**
     * 根据学生编号 课程编号 查看订单
     * @param stuId 学生编号
     * @param cId 课程编号
     * @return 订单对象
     */
    @Override
    public Order findAllOrderByStuIdAndCId(int stuId, int cId) {
        return dao.findAllOrderByStuIdAndCId(stuId, cId);
    }

    /**
     * 分页 根据学生编号 课程编号 查看订单
     * @param currentPage 当前页
     * @param pageSize 一页显示多少记录
     * @param stuId 学生编号
     * @param cId 课程编号
     * @return Page<Order> 对象
     */
    @Override
    public Page<Order> findAllOrderByStuIdAndCIdByPage(int currentPage, int pageSize, int stuId, int cId) {
        return dao.findAllOrderByStuIdAndCIdByPage(currentPage, pageSize, stuId, cId);
    }

    /**
     * 添加订单
     * @param order 订单对象
     * @return 布尔
     */
    @Override
    public boolean addOrder(Order order) {
        return dao.addOrder(order);
    }
}

package com.goodstudy.domain;

/**
 * 作者:wh
 * 订单实体类
 */
public class Order {
    private int waterId;//流水号
    private int orderId;//订单号
    private Student student;//学生类
    private Course course;//课程类
    private String orderTime;//下单时间
    private double orderPrice;//价格

    public Order() {
    }

    public Order(int waterId, int orderId, Student student, Course course, String orderTime, double orderPrice) {
        this.waterId = waterId;
        this.orderId = orderId;
        this.student = student;
        this.course = course;
        this.orderTime = orderTime;
        this.orderPrice = orderPrice;
    }

    public int getWaterId() {
        return waterId;
    }

    public void setWaterId(int waterId) {
        this.waterId = waterId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "waterId=" + waterId +
                ", orderId=" + orderId +
                ", student=" + student +
                ", course=" + course +
                ", orderTime='" + orderTime + '\'' +
                ", orderPrice=" + orderPrice +
                '}';
    }
}

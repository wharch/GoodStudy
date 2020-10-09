package com.goodstudy.controller;

import com.goodstudy.domain.Collection;
import com.goodstudy.domain.Course;
import com.goodstudy.domain.Order;
import com.goodstudy.domain.Student;
import com.goodstudy.service.CollectionService;
import com.goodstudy.service.CourseService;
import com.goodstudy.service.OrderService;
import com.goodstudy.service.impl.CollectionServiceImpl;
import com.goodstudy.service.impl.CourseServiceImpl;
import com.goodstudy.service.impl.OrderServiceImpl;
import com.goodstudy.util.RandomUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    private OrderService service = new OrderServiceImpl();
    private CourseService courseService = new CourseServiceImpl();
    private CollectionService collectionService = new CollectionServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if ("goAlipay".equals(op)){
            goAlipay(req,resp);
        }else if (op==null){
            addOrder(req,resp);
        }else if ("purchased".equals(op)){
            purchased(req,resp);
        }
    }

    private void purchased(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Student student = (Student) session.getAttribute("admin");
        List<Collection> allCollectionByStuId = collectionService.findAllCollectionByStuId(student.getStuId());
        req.setAttribute("allCollectionByStuId",allCollectionByStuId);
        List<Order> orders = service.findAllOrderByStuId(student.getStuId());
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("/front/purchased.jsp").forward(req,resp);
    }

    private void addOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String out_trade_no = req.getParameter("out_trade_no");
        System.out.println(out_trade_no);
        String total_amount = req.getParameter("total_amount");
        System.out.println(total_amount);
        HttpSession session = req.getSession();
        Student student = (Student) session.getAttribute("admin");
        String cid = (String) session.getAttribute("cid");
        Order order = new Order(0,out_trade_no,new Student(student.getStuId()),new Course(Integer.valueOf(cid)),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),Double.valueOf(total_amount));
        service.addOrder(order);
        resp.sendRedirect(this.getServletContext().getContextPath()+"/course?op=showCourse&cId="+cid);
    }

    private void goAlipay(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cId = req.getParameter("cId");
        String price = req.getParameter("price");
        HttpSession session = req.getSession();
        Student student = (Student) session.getAttribute("admin");
        String orderId = RandomUtil.randomOrdeId();
        session.setAttribute("cid",cId);
        req.setAttribute("oid",orderId);
        req.setAttribute("price",price);
        req.getRequestDispatcher("/front/pay.jsp").forward(req,resp);
    }
}

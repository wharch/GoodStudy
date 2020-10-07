package com.goodstudy.controller;

import com.goodstudy.domain.Kind;
import com.goodstudy.service.KindService;
import com.goodstudy.service.impl.KindServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author 刘美琦
 * 课程类别的控制层
 */
@WebServlet(name = "kindServlet",urlPatterns = "/kind")
public class KindServlet extends HttpServlet {
    private KindService kindService;

    public KindServlet() {
        this.kindService = new KindServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String op = req.getParameter("op");
            if("findAll".equals(op)){
                this.doFindAll(req,resp);
            }
    }

    /**
     * 不分页查询所有分类
     * @param req
     * @param resp
     */
    private void doFindAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Kind> allKind = kindService.findAllKind();
        req.setAttribute("allKind",allKind);
        req.getRequestDispatcher("/back/course-add.jsp").forward(req,resp);
    }
}

package com.goodstudy.controller;

import com.goodstudy.domain.Kind;
import com.goodstudy.service.KindService;
import com.goodstudy.service.impl.KindServiceImpl;
import com.goodstudy.util.Page;
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
            }else if ("addKind".equals(op)){
                this.addKind(req,resp);
            }else if("doFindAllByPage".equals(op)){
                this.doFindAllByPage(req, resp);
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

    /**
     * 分页查询所有分类
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void doFindAllByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String pageNum =  req.getParameter("pageNum");
        System.out.println(pageNum);
        Page<Kind> KindByKIdByPage = kindService.findByPage(pageNum !=null ? Integer.valueOf(pageNum) : 1,3);
        req.setAttribute("KindByKIdByPage",KindByKIdByPage);
        req.getRequestDispatcher("/back/kind-list.jsp").forward(req,resp);
    }

    /**
     * 添加课程类别
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void addKind(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String kindName = req.getParameter("name");
        boolean info = this.kindService.addKind(new Kind(kindName));
//        利用请求转发跳转界面 绝对路径
        req.getRequestDispatcher("/back/kind-list.jsp").forward(req,resp);

    }
}

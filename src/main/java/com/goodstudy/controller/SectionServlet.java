package com.goodstudy.controller;

import com.goodstudy.domain.Section;
import com.goodstudy.service.CourseService;
import com.goodstudy.service.SectionService;
import com.goodstudy.service.impl.CourseServiceImpl;
import com.goodstudy.service.impl.SectionServiceImpl;
import com.goodstudy.util.Page;

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
 * 章节的控制层
 */
@WebServlet(name = "sectionServlet",urlPatterns = "/section")
public class SectionServlet extends HttpServlet {
    private SectionService sectionService;
    private CourseService courseService;

    public SectionServlet() {
        this.sectionService = new SectionServiceImpl();
        this.courseService = new CourseServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if("add".equals(op)){
            this.doAdd(req,resp);
        }else if("findByCId".equals(op)){
            this.doFindByCId(req,resp);
        }else if("delete".equals(op)){
            this.doDel(req,resp);
        }
    }

    /**
     * 删除一个章节
     * @param req
     * @param resp
     */
    private void doDel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sectionId = req.getParameter("sectionId");
        boolean b = sectionService.delSection(Integer.parseInt(sectionId));
        if(b){
            PrintWriter out = resp.getWriter();
            out.write("yes");
            out.flush();
        }else{
            PrintWriter out = resp.getWriter();
            out.write("no");
            out.flush();
        }

    }

    /**
     * 根据课程编号查询章节名
     * @param req
     * @param resp
     */
    private void doFindByCId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cId = req.getParameter("cId");
        String pageNum = req.getParameter("pageNum");
        Page<Section> allSectionByPage = sectionService.findAllSectionByPage(Integer.parseInt(pageNum), 5,Integer.valueOf(cId));
        req.setAttribute("allSectionByPage",allSectionByPage);
        req.setAttribute("cId",cId);
        req.getRequestDispatcher("/back/section-list.jsp").forward(req,resp);
    }

    /**
     * 添加章节
     * @param req
     * @param resp
     */
    private void doAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sectionName = req.getParameter("sectionName");
        String cName = req.getParameter("cName");
        boolean b = sectionService.addSection(new Section(0, sectionName, courseService.findCrouseByName(cName)));
        if(b){
            PrintWriter out = resp.getWriter();
            out.write("<h1>添加成功！</h1>");
            req.getRequestDispatcher("course?op=findAllByPage");
        }else{
            PrintWriter out = resp.getWriter();
            out.write("<h1>添加失败！</h1>");
            req.getRequestDispatcher("course?op=findAllByPage");
        }
    }
}

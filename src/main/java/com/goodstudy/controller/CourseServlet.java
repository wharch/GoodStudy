package com.goodstudy.controller;

import com.goodstudy.domain.Course;
import com.goodstudy.domain.Kind;
import com.goodstudy.domain.Teacher;
import com.goodstudy.service.CourseService;
import com.goodstudy.service.impl.CourseServiceImpl;
import com.goodstudy.util.Page;
import com.goodstudy.util.RandomUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "courseServlet",urlPatterns = "/course")
@MultipartConfig
public class CourseServlet extends HttpServlet {
    private CourseService courseService;

    public CourseServlet() {
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
        }else if("findAllByPage".equals(op)){
            this.doFindAllByPage(req,resp);
        }else if("delete".equals(op)){
            this.doDown(req,resp);
        }
    }

    /**
     * 根据课程编号下架
     * @param req
     * @param resp
     */
    private void doDown(HttpServletRequest req, HttpServletResponse resp) {
        String cId = req.getParameter("cId");
    }

    /**
     * 分页查询所有的课程列表
     * @param req
     * @param resp
     */
    private void doFindAllByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String pageNum =  req.getParameter("pageNum");
         HttpSession session = req.getSession();
         Teacher teacherLogin = (Teacher) session.getAttribute("teacherLogin");
         Page<Course> courseByTIdByPage = courseService.findCourseByTIdByPage(Integer.parseInt(pageNum), 1, teacherLogin.gettId());
         req.setAttribute("courseByTIdByPage",courseByTIdByPage);
         req.getRequestDispatcher("/back/course-list.jsp").forward(req,resp);
    }

    /**
     * 添加课程
     * @param req
     * @param resp
     */
    private void doAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String cName = req.getParameter("cName");
        String kindId = req.getParameter("kindId");
        HttpSession session = req.getSession();
        Teacher teacherLogin =(Teacher) session.getAttribute("teacherLogin");
        //***********************图片上传开始*****************************
        Part cMaster = req.getPart("cMaster");
        String oldName = cMaster.getSubmittedFileName();
        //给图片起一个新的名称
        String newName = "/"+ RandomUtil.randomVedioAndImg()+oldName.substring(oldName.lastIndexOf("."));
        String path = this.getServletContext().getRealPath("/courseupload");
        //创建一个文件对象
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        //利用part接口进行图片上传
        cMaster.write(path+newName);
        //************************图片上传结束******************************
       String cInfo = req.getParameter("cInfo");
       String cPrice = req.getParameter("cPrice");
       boolean b = this.courseService.addCourse(new Course(1, cName, new Kind(Integer.parseInt(kindId), null), teacherLogin, newName, cInfo, Double.valueOf(cPrice), 2));
       if(b){
           PrintWriter out = resp.getWriter();
           out.write("<h1>添加成功</h1>");
           req.getRequestDispatcher("course?op=findAllByPage");
       }else{
           PrintWriter out = resp.getWriter();
           out.write("<h1>添加成功</h1>");
           req.setAttribute("courseMsg","添加失败");
           req.getRequestDispatcher("/back/course-add.jsp");
       }
    }
}

package com.goodstudy.controller;

import com.goodstudy.domain.*;
import com.goodstudy.service.*;
import com.goodstudy.service.impl.*;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "courseServlet",urlPatterns = "/course")
@MultipartConfig
public class CourseServlet extends HttpServlet {
    private CourseService courseService;
    private KindService kindService;
    private SectionService sectionService;
    private CourseInfoService courseInfoService;
    private OrderService orderService;
    public CourseServlet() {
        this.courseService = new CourseServiceImpl();
        this.kindService = new KindServiceImpl();
        this.sectionService = new SectionServiceImpl();
        this.courseInfoService = new CourseInfoServiceImpl();
        this.orderService = new OrderServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if("add".equals(op)){
            //lmq
            this.doAdd(req,resp);
        }else if("findAllByPage".equals(op)){
            //lmq
            this.doFindAllByPage(req,resp);
        }else if("delete".equals(op)){
            //lmq
            this.doDown(req,resp);
        }else if("findByName".equals(op)){
            //lmq
            this.doFindByName(req,resp);
        }else if ("pageFindAllCourse".equals(op)){
            pageFindAllCourse(req,resp);
        }else if ("showCourse".equals(op)){
            showCourse(req,resp);
        }
    }

    /**
     * 前端课程详情的展示
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void showCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cId = req.getParameter("cId");
        System.out.println(cId);
        List<List<CourseInfo>> lci = new ArrayList<>();
        Course course = courseService.findCrouseById(Integer.valueOf(cId));
        req.setAttribute("course",course);
        System.out.println(course);
        List<Section> sections = sectionService.findAllSection(Integer.valueOf(cId));
        req.setAttribute("sections",sections);
        System.out.println(sections);
        for (Section section : sections) {
            List<CourseInfo> courseInfos = courseInfoService.selectBysId(section.getSectionId());
            lci.add(courseInfos);
        }
        req.setAttribute("lci",lci);
        HttpSession session = req.getSession();
        Student student = (Student) session.getAttribute("admin");
        System.out.println(student);
        if (student==null){
            resp.sendRedirect(this.getServletContext().getContextPath()+"/front/login.jsp");
        }else {
            //0 为已购买 1为未购买
            int flag = 0;
            if (orderService.findAllOrderByStuIdAndCId(student.getStuId(), Integer.valueOf(cId))==null){
                flag=1;
            }
            req.setAttribute("flag",flag);
        }

        System.out.println(lci);
        req.getRequestDispatcher("/front/courseDetail.jsp").forward(req,resp);


    }

    /**
     * 分页模糊查询所有的课程
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void pageFindAllCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("pageNum");
        String key = req.getParameter("key");
        Page<Course> courses = courseService.findAllCourseByPageLike(pageNum == null ? 1 : Integer.valueOf(pageNum), 8, key == null ? "" : key);
        req.setAttribute("courses",courses);
        req.setAttribute("cn",key);
        req.getRequestDispatcher("/front/courseList.jsp").forward(req,resp);
    }
    /**
     * 根据课程名查询课程信息
     * @param req
     * @param resp
     */
    private void doFindByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cName = req.getParameter("cName");
        Course crouseByName = courseService.findCrouseByName(cName);
        req.setAttribute("courseByName",crouseByName);
        req.getRequestDispatcher("/back/section-add.jsp").forward(req,resp);
    }

    /**
     * 根据课程编号下架
     * @param req
     * @param resp
     */
    private void doDown(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cId = req.getParameter("cId");
        boolean b = courseService.delCourse(Integer.parseInt(cId));
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

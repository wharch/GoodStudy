package com.goodstudy.controller;

import com.goodstudy.domain.Teacher;
import com.goodstudy.service.TeacherService;
import com.goodstudy.service.impl.TeacherServiceImpl;
import com.goodstudy.util.Page;
import com.goodstudy.util.RandomUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "teacherServlet",urlPatterns = "/teacher")
@MultipartConfig
public class TeacherServlet extends HttpServlet {
    private TeacherService teacherService;

    public TeacherServlet() {
        this.teacherService = new TeacherServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if("login".equals(op)){
            //教师登录
            this.doLogin(req,resp);
        }else if("logout".equals(op)){
            //教师退出
            this.doLogout(req,resp);
        }else if("editPersonal".equals(op)){
            //教师个人信息的修改
            this.doEdit(req,resp);
        }else if("findByTId".equals(op)){
            //根据教师编号查询教师的个人信息
            this.doFindByTId(req,resp);
        }else if ("register".equals(op)) {
            //教师注册
            this.register(req, resp);
        }else if ("doFindAllByPage".equals(op)){
            //分页查询全部教师信息
            this.doFindAllByPage(req, resp);
        }
    }


    /**
     * 分页查询全部教师信息
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void doFindAllByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String pageNum =  req.getParameter("pageNum");
        System.out.println(pageNum);
        Page<Teacher> TeacherdoFindAllByPage = teacherService.selectAllTeacherByPage(pageNum !=null ? Integer.valueOf(pageNum) : 1,1);
        req.setAttribute("TeacherdoFindAllByPage",TeacherdoFindAllByPage);
        req.getRequestDispatcher("back/teacher-list.jsp").forward(req,resp);
    }
    /**
     * 教师注册
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String tName = req.getParameter("tName");
        String sex = req.getParameter("tSex");
        String hiredate = req.getParameter("hiredate");
        String tPhone = req.getParameter("tPhone");
        String password = req.getParameter("password");
        String certificate = req.getParameter("certificate");
        Part certificate_img = req.getPart("certificate_img");
        String oldName = certificate_img.getSubmittedFileName();
        String newName = "/"+RandomUtil.randomVedioAndImg() + oldName.substring(oldName.lastIndexOf("."));
        String path = this.getServletContext().getRealPath("/certificate");
        System.out.println(path);
        File f = new File(path);
        if (!f.exists()) {
            f.mkdir();
        }
        certificate_img.write(path + newName);
        Teacher teacher = new Teacher(0, tName, sex, hiredate, tPhone, null, RandomUtil.randomTUsername(), password, "default.png", 0, 0, certificate, newName);
        if (teacherService.insertTeacher(teacher)){
            req.setAttribute("teacherRegisterMsg","yes");
            req.getRequestDispatcher("back/login.jsp").forward(req,resp);
        }else {
            req.setAttribute("teacherRegisterMsg","no");
            req.getRequestDispatcher("back/teacherRegister.jsp").forward(req,resp);
        }
    }
    /**
     * 根据教师编号查询教师的个人信息
     * @param req
     * @param resp
     */
    private void doFindByTId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Teacher teacherLogin = (Teacher) session.getAttribute("teacherLogin");
        Teacher teacher = teacherService.selectTeacherByTId(teacherLogin.gettId());
        req.setAttribute("teacherOld",teacher);
        req.getRequestDispatcher("back/teacher-edit.jsp").forward(req,resp);
    }

    /**
     * 教师的个人信息的修改
     * @param req
     * @param resp
     */
    private void doEdit(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String tId = req.getParameter("tId");
        String tName = req.getParameter("tName");
        String tGender = req.getParameter("tGender");
        String hiredate = req.getParameter("hiredate");
        String tPhone = req.getParameter("tPhone");
        String tInfo = req.getParameter("tInfo");
        String tUsername = req.getParameter("tUsername");
        String tPwd = req.getParameter("tPwd");
        String tHeadImgName = req.getParameter("tHeadImgName");
        //***********************图片上传开始*****************************
        Part tHeadImg = req.getPart("tHeadImg");
        String newName = tHeadImgName;
        if(tHeadImg.getSize() != 0){
            String oldName = tHeadImg.getSubmittedFileName();
            //给图片起一个新的名称
            newName = "/"+ RandomUtil.randomVedioAndImg()+oldName.substring(oldName.lastIndexOf("."));
            String path = this.getServletContext().getRealPath("/teacherHeadImg");
            //创建一个文件对象
            File file = new File(path);
            if(!file.exists()){
                file.mkdir();
            }
            //利用part接口进行图片上传
            tHeadImg.write(path+newName);
        }

        //************************图片上传结束******************************
        Teacher teacher = new Teacher(Integer.parseInt(tId),tName,tGender,hiredate,tPhone ,tInfo.trim(),tPwd,newName);
        boolean b = teacherService.updateTeacher(teacher);
        if(b){
            req.setAttribute("editMsg","yes");
            req.getRequestDispatcher("/teacher?op=findByTId").forward(req,resp);
        }else{
            req.setAttribute("editMsg","no");
            req.getRequestDispatcher("/teacher?op=findByTId").forward(req,resp);
        }
    }

    /**
     * 教师退出登录
     * @param req
     * @param resp
     */
    private void doLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user = req.getParameter("user");
        if("admin".equals(user)){
            session.removeAttribute("adminLogin");

        }else if("teacher".equals(user)){
            session.removeAttribute("teacherLogin");
        }
        req.setAttribute("msg",null);
        req.getRequestDispatcher("back/login.jsp").forward(req,resp);
    }

    /**
     * 教师登录
     * @param req
     * @param resp
     */
    private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String pwd = req.getParameter("pwd");
        Teacher teacher = this.teacherService.teacherLogin(account, pwd);
        //当存在该教师记录，则判读角色是管理员还是教师
        if(teacher != null){
            //当教师的状态为正常 ---1
            if(teacher.gettState() == 1){
                //当角色为管理员 ---1
                if(1 == teacher.getRole()){
                    HttpSession session = req.getSession();
                    session.setAttribute("adminLogin",teacher);
                    req.setAttribute("msg",null);
                    req.setAttribute("adminLogin",teacher);
                    req.getRequestDispatcher("back/admin-index.jsp").forward(req,resp);
                 //当角色为教师 ---2
                }else if(2 == teacher.getRole()){
                    HttpSession session = req.getSession();
                    session.setAttribute("teacherLogin",teacher);
                    req.setAttribute("msg",null);
                    req.setAttribute("teacherLogin",teacher);
                    req.getRequestDispatcher("back/teacher-index.jsp").forward(req,resp);
                }

             //当教师状态为异常 ---2
            }else{
                req.setAttribute("msg","本账号未通过审核，请耐心等待审核");
                req.getRequestDispatcher("back/login.jsp").forward(req,resp);
            }
        //当不存在该教师记录则重新返回登录页面，说明用户名或密码填写错误
        }else{
            req.setAttribute("msg","用户名或密码错误");
            req.getRequestDispatcher("back/login.jsp").forward(req,resp);
        }

    }
}

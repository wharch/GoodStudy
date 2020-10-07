package com.goodstudy.controller;

import com.goodstudy.domain.Student;
import com.goodstudy.service.StudentService;
import com.goodstudy.service.impl.StudentServiceImpl;
import com.goodstudy.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet(name = "StudentServlet",urlPatterns = "/admin")
/*
* 支持二进制文件上传
* */
@MultipartConfig

public class StudentServlet extends HttpServlet {
//创建业务层对象
    private StudentService studentService;
    public StudentServlet(){
        this.studentService = new StudentServiceImpl();
    }
/*
* doGet方法
* */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    /*
    * doPost方法
    * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        try {
            req.setCharacterEncoding("utf-8");//设置编码方式
            String op = req.getParameter("op");//获取op参数值
            //判断op参数要干什么 ?
            if ("login".equals(op)){
                this.login(req,resp);
            }else if ("reset".equals(op)){
                this.reset(req,resp);
            }else if ("addStudent".equals(op)){
                this.addStudent(req,resp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    /*
    * 注销的方法
    * */
    private void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        HttpSession session = req.getSession();
        session.removeAttribute("admin");
        req.setAttribute("message","注销成功，请重新登陆");
        try {
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    * 登录的方法
    * */
    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String userName = req.getParameter("username");
        System.out.println(userName);
        String password = req.getParameter("pwd");
        System.out.println(password);
        Student student = this.studentService.findByNameAndPassword(userName,password);
        if (student  == null){
            req.setAttribute("message","对不起，登陆失败，请重新登陆");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else{
            //将用户信息存储到session中
            HttpSession session = req.getSession();
            session.setAttribute("admin",student );
            //下面四行仅是测试 解除会空指针 servlet上下文是优先运行 是一个全局的储存信息空间 getAttribute为空  无法转int 故为空
            //只要是登陆成功就证明有人登陆了 我们就需要把登陆的人数记录到全局变量servlet对象中
//            int num = (int) this.getServletContext().getAttribute("num");
            //将数值+1 再存储到全局变量中
//            this.getServletContext().setAttribute("num",num+1);
            //重定向到某某文件
            resp.sendRedirect("back/admin-index.jsp");

        }
    }
    /*
    * 注册的方法
    * */
    protected void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        //接收用户传递过来的用户信息
        String stu_name = req.getParameter("name");
        System.out.println(stu_name);
        String stu_gender = req.getParameter("gender");
        System.out.println(stu_gender);
        String stu_birthday = req.getParameter("birthday");
        System.out.println(stu_birthday);
        String stu_username = req.getParameter("username");
        System.out.println(stu_username);
        String stu_pwd = req.getParameter("pwd");
        System.out.println(stu_pwd);
        String stu_email = req.getParameter("email");
        System.out.println(stu_email);
        //获取图片part对象
        Part part = req.getPart("stu_head_img");
        //获取提交图片名称
        String oldName = part.getSubmittedFileName();
        //给图片起一个新图片名称
        String newName="/"+
                UUID.randomUUID().toString().replaceAll("-","").toUpperCase()
                +oldName.substring(oldName.lastIndexOf("."));
        System.out.println("old:"+oldName+",newName:"+newName);
        //找到文件存储到位置 获取项目运行的本地路径
        String path=this.getServletContext().getRealPath("/upload");
        //创建一个文件对象
        File f = new File(path);
        //判断文件是否存在
        if (!f.exists()){
            //创建文件夹
            f.mkdir();
        }
        //利用part接口进行图片上传
        part.write(path+newName);
        //输出图片路径
//        System.out.println(f.getAbsoluteFile());
        //调用添加学生信息的方法
        boolean info = this.studentService.addStudent(new Student(
                stu_name,
                stu_gender,
                stu_birthday,
                stu_username,
                stu_pwd,
                stu_email,
                newName

        ));

        System.out.println(info);

//        利用请求转发跳转界面 绝对路径
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

}

package com.goodstudy.controller;

import com.goodstudy.domain.Collection;
import com.goodstudy.domain.Course;
import com.goodstudy.domain.Student;
import com.goodstudy.service.CollectionService;
import com.goodstudy.service.impl.CollectionServiceImpl;
import jdk.nashorn.internal.ir.Flags;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "collectionServlet" ,urlPatterns = "/collection")
public class CollectionServlet extends HttpServlet {
    private CollectionService collectionService;

    public CollectionServlet() {
        this.collectionService = new CollectionServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if("changeCollection".equals(op)){
            this.doChangeCollection(req,resp);
        }
    }

    /**
     * 更改收藏的状态
     * @param req
     * @param resp
     */
    private void doChangeCollection(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cId= req.getParameter("cId");
        HttpSession session = req.getSession();
        Student student = (Student) session.getAttribute("admin");
        boolean b = false;
        String flag = null;
        Collection collectionByCIdAndStuId = collectionService.findCollectionByCIdAndStuId(Integer.parseInt(cId), student.getStuId());
        if(collectionByCIdAndStuId == null){
            b = collectionService.insertCollection(new Collection(new Course(Integer.valueOf(cId)),new Student(Integer.valueOf(student.getStuId()))));
            flag = "true";
        }else if (collectionByCIdAndStuId != null){
            b = collectionService.deleteCollectionById(collectionByCIdAndStuId.getCollectionId());
            flag = "false";
        }
        if(b){
            PrintWriter out = resp.getWriter();
            out.write(flag);
            out.flush();
        }else{
            PrintWriter out = resp.getWriter();
            out.write("no");
            out.flush();
        }
    }
}

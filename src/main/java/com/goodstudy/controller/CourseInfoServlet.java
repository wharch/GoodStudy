package com.goodstudy.controller;

import com.goodstudy.domain.Course;
import com.goodstudy.domain.CourseInfo;
import com.goodstudy.domain.Section;
import com.goodstudy.service.CourseInfoService;
import com.goodstudy.service.impl.CourseInfoServiceImpl;
import com.goodstudy.util.Page;
import com.goodstudy.util.RandomUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/courseInfo")
@MultipartConfig
public class CourseInfoServlet extends HttpServlet {
    private CourseInfoService service = new CourseInfoServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if ("addCourseInfo".equals(op)) {
            addCourseInfo(req, resp);
        }else if ("reviewVideo".equals(op)){
            reviewVideo(req,resp);
        }else if ("updateState".equals(op)){
            updateState(req,resp);
        }
    }

    private void updateState(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String state = req.getParameter("state");
        String infoId = req.getParameter("infoId");
        service.updateCourseInfoStateById(new CourseInfo(Integer.valueOf(infoId), null, null, null, null, null, Integer.valueOf(state)));
        resp.sendRedirect(this.getServletContext().getContextPath()+"/courseInfo?op=reviewVideo&infoState=2");
    }

    /**
     * 分页获取数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void reviewVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String infoState = req.getParameter("infoState");
        String pageNum = req.getParameter("pageNum");
        Page<CourseInfo> courseInfos = service.findCrouseInfoByStateAndPage(Integer.valueOf(infoState), pageNum==null?1:Integer.valueOf(pageNum), 5);
        System.out.println(courseInfos);
        req.setAttribute("courseinfo_page",courseInfos);
        req.setAttribute("state",infoState);
        req.getRequestDispatcher("/back/reviewVideo.jsp").forward(req,resp);
    }

    private void addCourseInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Part video = req.getPart("video");
        String knobbleName = req.getParameter("knobbleName");
        Part note = req.getPart("note");
        String videoName = video.getSubmittedFileName();
        String newVideoName = "";
        if (videoName != null && !videoName.equals("")) {
            newVideoName = "/" + RandomUtil.randomVedioAndImg() + videoName.substring(videoName.lastIndexOf("."));
            String path = this.getServletContext().getRealPath("/video");
            System.out.println(path);
            File f = new File(path);
            if (!f.exists()) {
                f.mkdir();
            }
            video.write(path + newVideoName);
        }

        String noteName = note.getSubmittedFileName();
        String newNoteName = "";
        if (noteName != null && !noteName.equals("")) {
            newNoteName = "/" + RandomUtil.randomVedioAndImg() + noteName.substring(noteName.lastIndexOf("."));
            String path = this.getServletContext().getRealPath("/note");
            System.out.println(path);
            File f = new File(path);
            if (!f.exists()) {
                f.mkdir();
            }
            note.write(path + newNoteName);
        }
        //获取当前的课程id
        String cId = req.getParameter("cId").trim();
        //获取当前的章节id
        String sectionId = req.getParameter("sId");
        CourseInfo courseInfo = new CourseInfo(0, newVideoName, newNoteName,knobbleName,new Section(Integer.valueOf(sectionId.trim()), null, null), new Course(Integer.valueOf(cId)), 0);
        if (service.addCourseInfo(courseInfo)){
            req.setAttribute("addCourseMsg","yes");
            req.getRequestDispatcher("/section?op=findByCId&pageNum=1&cId="+cId).forward(req,resp);
        }else {
            req.setAttribute("addCourseMsg","no");
            req.getRequestDispatcher("/section?op=findByCId&pageNum=1&cId="+cId).forward(req,resp);
        }

    }
}

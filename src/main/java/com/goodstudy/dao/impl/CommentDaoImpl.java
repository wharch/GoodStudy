package com.goodstudy.dao.impl;

import com.goodstudy.dao.CommentDao;
import com.goodstudy.domain.*;
import com.goodstudy.util.DBUtil;
import com.goodstudy.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 评论commentDao的实现
 * @author 刘美琦
 */
public class CommentDaoImpl implements CommentDao {
    /**
     * 新增一条评论
     * @param comment
     * @return
     */
    @Override
    public boolean insertComment(Comment comment) {
        String sql = "insert into comment values(null,?,?,?,?,?)";
        int i = DBUtil.doUpdate(sql, comment.getStudent().getStuId(), comment.getScore(), comment.getComment(), comment.getCommTime(), comment.getCourse().getcId());
        return i>0?true:false;
    }

    /**
     * 根据评论编号删除评论
     * @param commentId
     * @return
     */
    @Override
    public boolean deleteCommentById(int commentId) {
        String sql = "delete from comment where comm_id = ?";
        int i = DBUtil.doUpdate(sql, commentId);
        return i>0?true:false;
    }

    /**
     * 根据课程编号不分页查询评论列表
     * @param cId
     * @return
     */
    @Override
    public List<Comment> findAllComment(int cId) {
        String sql = "select * from comment where c_id = ?";
        String sqlStudent = "select * from student where stu_id = ?";
        String sqlCourse = "select * from course where c_id = ?";
        ResultSet rs = DBUtil.doQuery(sql, cId);
        List<Comment> comments = new ArrayList<>();
        try {
            while (rs.next()){
                int commId = rs.getInt("comm_id");
                int stuId = rs.getInt("stu_id");
                //根据学生编号查询学生记录
                ResultSet rsStudent = DBUtil.doQuery(sqlStudent, stuId);
                Student student = null;
                if (rsStudent.next()){
                    String stuName = rsStudent.getString("stu_name");
                    String stuGender = rsStudent.getString("stu_gender");
                    String stuBirthday = rsStudent.getString("stu_birthday");
                    String stuUsername = rsStudent.getString("stu_username");
                    String stuPwd = rsStudent.getString("stu_pwd");
                    String stuEmail = rsStudent.getString("stu_email");
                    String stuHeadImg = rsStudent.getString("stu_head_img");
                    student = new Student(stuId,stuName,stuGender,stuBirthday,stuUsername,stuPwd,stuEmail,stuHeadImg);
                }
                int score = rs.getInt("score");
                String comment = rs.getString("comment");
                String commtime = rs.getString("commtime"); 
                //根据课程编号查询课程
                ResultSet rsCourse = DBUtil.doQuery(sqlCourse, cId);
                Course course = null;
                if(rsCourse.next()){
                    String cName = rsCourse.getString("c_name");
                    int kindId = rsCourse.getInt("kind_id");
                    int tId = rsCourse.getInt("t_id");
                    String cMaster = rsCourse.getString("c_master");
                    String cInfo = rsCourse.getString("c_info");
                    double cPrice = rsCourse.getDouble("c_price");
                    int cStatus = rsCourse.getInt("c_status");
                    course = new Course(cId,cName,new Kind(kindId,null),new Teacher(tId),cMaster,cInfo,cPrice,cStatus);
                }
                Comment comment1 = new Comment(commId,student,score,comment,commtime,course);
                comments.add(comment1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    /**
     * 根据课程编号分页查询评论
     * @param cId
     * @return
     */
    @Override
    public Page<Comment> findAllCommentByPage(int cId,int currentPage,int pageSize) {
        String sql = "select * from comment where c_id = ?";
        String sqlStudent = "select * from student where stu_id = ?";
        String sqlCourse = "select * from course where c_id = ?";
        Page<Comment> page = DBUtil.doQueryByPage(sql, currentPage, pageSize, cId);
        ResultSet rs = page.getRs();
        List<Comment> comments = new ArrayList<>();
        try {
            while (rs.next()){
                int commId = rs.getInt("comm_id");
                int stuId = rs.getInt("stu_id");
                //根据学生编号查询学生记录
                ResultSet rsStudent = DBUtil.doQuery(sqlStudent, stuId);
                Student student = null;
                if (rsStudent.next()){
                    String stuName = rsStudent.getString("stu_name");
                    String stuGender = rsStudent.getString("stu_gender");
                    String stuBirthday = rsStudent.getString("stu_birthday");
                    String stuUsername = rsStudent.getString("stu_username");
                    String stuPwd = rsStudent.getString("stu_pwd");
                    String stuEmail = rsStudent.getString("stu_email");
                    String stuHeadImg = rsStudent.getString("stu_head_img");
                    student = new Student(stuId,stuName,stuGender,stuBirthday,stuUsername,stuPwd,stuEmail,stuHeadImg);
                }
                int score = rs.getInt("score");
                String comment = rs.getString("comment");
                String commtime = rs.getString("commtime");
                //根据课程编号查询课程
                ResultSet rsCourse = DBUtil.doQuery(sqlCourse, cId);
                Course course = null;
                if(rsCourse.next()){
                    String cName = rsCourse.getString("c_name");
                    int kindId = rsCourse.getInt("kind_id");
                    int tId = rsCourse.getInt("t_id");
                    String cMaster = rsCourse.getString("c_master");
                    String cInfo = rsCourse.getString("c_info");
                    double cPrice = rsCourse.getDouble("c_price");
                    int cStatus = rsCourse.getInt("c_status");
                    course = new Course(cId,cName,new Kind(kindId,null),new Teacher(tId),cMaster,cInfo,cPrice,cStatus);
                }
                Comment comment1 = new Comment(commId,student,score,comment,commtime,course);
                comments.add(comment1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        page.setData(comments);
        return page;
    }

    /**
     * 根据学生编号查询评论列表
     * @param stuId
     * @return
     */
    @Override
    public List<Comment> findCommentBySId(int stuId) {
        String sql = "select * from comment where stu_id = ?";
        String sqlStudent = "select * from student where stu_id = ?";
        String sqlCourse = "select * from course where c_id = ?";
        ResultSet rs = DBUtil.doQuery(sql, stuId);
        List<Comment> comments = new ArrayList<>();
        try {
            while (rs.next()){
                int commId = rs.getInt("comm_id");
                //根据学生编号查询学生记录
                ResultSet rsStudent = DBUtil.doQuery(sqlStudent, stuId);
                Student student = null;
                if (rsStudent.next()){
                    String stuName = rsStudent.getString("stu_name");
                    String stuGender = rsStudent.getString("stu_gender");
                    String stuBirthday = rsStudent.getString("stu_birthday");
                    String stuUsername = rsStudent.getString("stu_username");
                    String stuPwd = rsStudent.getString("stu_pwd");
                    String stuEmail = rsStudent.getString("stu_email");
                    String stuHeadImg = rsStudent.getString("stu_head_img");
                    student = new Student(stuId,stuName,stuGender,stuBirthday,stuUsername,stuPwd,stuEmail,stuHeadImg);
                }
                int score = rs.getInt("score");
                String comment = rs.getString("comment");
                String commtime = rs.getString("commtime");
                //根据课程编号查询课程
                int cId = rs.getInt("c_id");
                ResultSet rsCourse = DBUtil.doQuery(sqlCourse, cId);
                Course course = null;
                if(rsCourse.next()){
                    String cName = rsCourse.getString("c_name");
                    int kindId = rsCourse.getInt("kind_id");
                    int tId = rsCourse.getInt("t_id");
                    String cMaster = rsCourse.getString("c_master");
                    String cInfo = rsCourse.getString("c_info");
                    double cPrice =rsCourse.getDouble("c_price");
                    int cStatus = rsCourse.getInt("c_status");
                    course = new Course(cId,cName,new Kind(kindId,null),new Teacher(tId),cMaster,cInfo,cPrice,cStatus);
                }
                Comment comment1 = new Comment(commId,student,score,comment,commtime,course);
                comments.add(comment1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    /**
     * 根据学生编号分页查询评论列表
     * @param stuId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page<Comment> findCommentBySIdByPage(int stuId, int currentPage, int pageSize) {
        String sql = "select * from comment where stu_id = ?";
        String sqlStudent = "select * from student where stu_id = ?";
        String sqlCourse = "select * from course where c_id = ?";
        Page<Comment> page = DBUtil.doQueryByPage(sql, currentPage, pageSize, stuId);
        ResultSet rs = page.getRs();
        List<Comment> comments = new ArrayList<>();
        try {
            while (rs.next()){
                int commId = rs.getInt("comm_id");
                //根据学生编号查询学生记录
                ResultSet rsStudent = DBUtil.doQuery(sqlStudent, stuId);
                Student student = null;
                if (rsStudent.next()){
                    String stuName = rsStudent.getString("stu_name");
                    String stuGender = rsStudent.getString("stu_gender");
                    String stuBirthday = rsStudent.getString("stu_birthday");
                    String stuUsername = rsStudent.getString("stu_username");
                    String stuPwd = rsStudent.getString("stu_pwd");
                    String stuEmail = rsStudent.getString("stu_email");
                    String stuHeadImg = rsStudent.getString("stu_head_img");
                    student = new Student(stuId,stuName,stuGender,stuBirthday,stuUsername,stuPwd,stuEmail,stuHeadImg);
                }
                int score = rs.getInt("score");
                String comment = rs.getString("comment");
                String commtime = rs.getString("commtime");
                //根据课程编号查询课程
                int cId = rs.getInt("c_id");
                ResultSet rsCourse = DBUtil.doQuery(sqlCourse, cId);
                Course course = null;
                if(rsCourse.next()){
                    String cName = rsCourse.getString("c_name");
                    int kindId = rsCourse.getInt("kind_id");
                    int tId = rsCourse.getInt("t_id");
                    String cMaster = rsCourse.getString("c_master");
                    String cInfo = rsCourse.getString("c_info");
                    double cPrice = rsCourse.getDouble("c_price");
                    int cStatus = rsCourse.getInt("c_status");
                    course = new Course(cId,cName,new Kind(kindId,null),new Teacher(tId),cMaster,cInfo,cPrice,cStatus);
                }
                Comment comment1 = new Comment(commId,student,score,comment,commtime,course);
                comments.add(comment1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        page.setData(comments);
        return page;
    }
}

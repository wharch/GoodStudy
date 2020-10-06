package com.goodstudy.dao.impl;

import com.goodstudy.dao.StudentDao;
import com.goodstudy.domain.Course;
import com.goodstudy.domain.Student;
import com.goodstudy.util.DBUtil;
import com.goodstudy.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
* 孙向锋
* studentDao 的实现
* */
public class StudentDaoImpl implements StudentDao {
    /**
     * 添加学生
     * @param student 学生对象
     * @return 布尔
     */
    @Override
    public boolean insertStudent(Student student) {
        //执行sql语句并且获取里面？的值
        int i = DBUtil.doUpdate("insert into student(stu_id,stu_name,stu_gender,stu_birthday,stu_username,stu_pwd,stu_email,stu_head_img) values(?,?,?,?,?,?,?,?)",
                student.getStuId(),student.getStuName(),student.getStuGender(),student.getStuBirthday(),student.getStuUsername(),student.getStuPwd(),student.getStuEmail(),student.getStuHeadImg());
        //返回i
        return i>0?true:false;
    }
    /**
     * 删除学生
     * @param stuid 学生id
     * @return 布尔
     */
    @Override
    public boolean deleteStudent(int stuid) {
        //执行sql语句并且获取里面？的值
        int i = DBUtil.doUpdate("delete from student where stu_id=?",stuid);
        //返回i
        return i>0?true:false;
    }
    /**
     * 修改学生
     * @param student 学生对象
     * @return 布尔
     */
    @Override
    public boolean updateStudent(Student student) {
        //执行sql语句并且获取里面？的值
        int i = DBUtil.doUpdate("update student set stu_name=?,stu_gender=?,stu_birthday=?,stu_username=?,stu_pwd=?,stu_email=?where stu_id=?",
                student.getStuName(),student.getStuGender(),student.getStuBirthday(),student.getStuUsername(),student.getStuPwd(),student.getStuEmail(),student.getStuId());
        //返回i
        return i>0?true:false;
    }
    /**
     * 分页 查看所有学生
     * @param currentPage 当前页
     * @param pageSize 一页显示多少记录
     * @return Page<Student> 对象
     */
    @Override
    public Page<Student> selectAllStudent(int currentPage,int pageSize) {
        String sql = "select * from student";
        Page page = DBUtil.doQueryByPage(sql,currentPage,pageSize);
        ResultSet rs = page.getRs();
        List<Student> students = new ArrayList<Student>();
        try {
            while (rs.next()) {
                students.add(new Student(
                rs.getInt("stu_id"),
                rs.getString("stu_name"),
                rs.getString("stu_gender"),
                rs.getString("stu_birthday"),
                rs.getString("stu_username"),
                rs.getString("stu_pwd"),
                rs.getString("stu_email"),
                rs.getString("stu_head_img")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        page.setData(students);
        return page;
    }
    /**
     * 查看全部学生
     * @return List<Student> 集合
     */
    @Override
    public List<Student> findAllStudent() {
        ResultSet rs = DBUtil.doQuery("select * from student");
        List<Student> students = new ArrayList<Student>();
        try {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("stu_id"),
                        rs.getString("stu_name"),
                        rs.getString("stu_gender"),
                        rs.getString("stu_birthday"),
                        rs.getString("stu_username"),
                        rs.getString("stu_pwd"),
                        rs.getString("stu_email"),
                        rs.getString("stu_head_img")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    /**
     * 根据学生名模糊查询全部信息
     * @param key  关键字要查询的关键字
     * @return List<Student> 集合
     */
    @Override
    public List<Student> findAllStudentByLike(String key) {
     String sql = "select * from student where stu_name like ? ";
     ResultSet rs = DBUtil.doQuery(sql,"%"+key+"%");
        List<Student> students = new ArrayList<>();
        try {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("stu_id"),
                        rs.getString("stu_name"),
                        rs.getString("stu_gender"),
                        rs.getString("stu_birthday"),
                        rs.getString("stu_username"),
                        rs.getString("stu_pwd"),
                        rs.getString("stu_email"),
                        rs.getString("stu_head_img")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    /**
     * 根据姓名查询学生信息
     * Student 学生对象
     */
    @Override
    public Student selectByName(String stuName) {
        ResultSet rs = DBUtil.doQuery("select * from student where stu_name=?",stuName);
        try {
            if (rs.next()) {
                return new Student(rs.getInt("stu_id"),
                        rs.getString("stu_name"),
                        rs.getString("stu_gender"),
                        rs.getString("stu_birthday"),
                        rs.getString("stu_username"),
                        rs.getString("stu_pwd"),
                        rs.getString("stu_email"),
                        rs.getString("stu_head_img"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}

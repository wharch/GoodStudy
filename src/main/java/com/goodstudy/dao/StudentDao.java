package com.goodstudy.dao;
/*
* 孙向锋
* 学生类dao接口
* */

import com.goodstudy.domain.Student;
import com.goodstudy.util.Page;

import java.util.List;
/*学生Dao
 * 孙向锋
 * */
public interface StudentDao {
    //添加学生
    boolean insertStudent(Student student);
    //根据id删除学生
    boolean deleteStudent(int stuId);
    //修改学生信息
    boolean updateStudent(Student student);
    //分页查询全部学生
    Page<Student> selectAllStudent(int currentPage,int pageSize);
    //按照姓名模糊查询学生
    List<Student> findAllStudentByLike(String key);
    //查询全部学生
    List<Student>findAllStudent();
    //根据学生姓名查询学生信息
    Student selectByName(String stuName);
}

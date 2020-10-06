package com.goodstudy.service;

import com.goodstudy.domain.Course;
import com.goodstudy.domain.Student;
import com.goodstudy.util.Page;

import java.util.List;
/*
* 孙向锋
* */
public interface StudentService {
    //新增学生
    boolean addStudent(Student student);
    //根据id查找学生信息
    //Student findById(int stuId);
    //修改学生信息
    boolean changeStudent(Student student);
    //删除学生
    boolean removeStudent(int stuId);
    //根据学生姓名查询学生信息
    Student findByName(String stuName);
    //分页查询
    Page<Student> findByPage(int currentPage, int pageSize);
    //模糊查询课程
    List<Student> findAllStudentByLike(String key);
}

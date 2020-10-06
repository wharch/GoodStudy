package com.goodstudy.service.impl;

import com.goodstudy.dao.impl.StudentDaoImpl;
import com.goodstudy.dao.StudentDao;
import com.goodstudy.domain.Course;
import com.goodstudy.domain.Student;
import com.goodstudy.service.StudentService;
import com.goodstudy.util.Page;

import java.util.List;

/**
 * 学生的实现类
 * @author 孙向锋
 */
public class StudentServiceImpl implements StudentService {
    //创建dao实例对象
    StudentDao studentDao = new StudentDaoImpl();
    /**
     * 添加学生信息
     * @param student
     * @return
     */
    @Override
    public boolean addStudent(Student student) {
        //判断当前录入的员工信息是否已经存在
        Student studentByName = studentDao.selectByName(student.getStuName());
        if(studentByName != null){
            return false;
        }else{
            return studentDao.insertStudent(student);
        }

    }
    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @Override
    public boolean changeStudent(Student student) {
        return this.studentDao.updateStudent(student);
    }
    /**
     * 根据id删除学生信息
     * @param stuId
     * @return
     */
    @Override
    public boolean removeStudent(int stuId) {
        return this.studentDao.deleteStudent(stuId);
    }
    /**
     * 根据学生姓名查询信息
     * @param stuName
     * @return
     */
    @Override
    public Student findByName(String stuName) {
        return studentDao.selectByName(stuName);
    }
    /**
     * 分页查询全部的学生信息
     * @param currentPage 当前页
     * @param pageSize 每页显示的数量
     * Page<Student> 集合对象
     * @return
     */
    @Override
    public Page<Student> findByPage(int currentPage, int pageSize) {
        return this.studentDao.selectAllStudent(currentPage, pageSize);
    }
    /**
     * 模糊查询全部的学生信息
     * Page<Student> 集合对象
     * @return
     */
    @Override
    public List<Student> findAllStudentByLike(String key) {
        return studentDao.findAllStudentByLike(key);
    }
}

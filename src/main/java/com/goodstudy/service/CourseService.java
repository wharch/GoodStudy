package com.goodstudy.service;

import com.goodstudy.domain.Course;
import com.goodstudy.util.Page;

import java.util.List;

/**
 * 作者:wh
 * 课程service接口
 */
public interface CourseService {
    //分页查询全部课程
    Page<Course> findAllCourseByPage(int currentPage, int pageSize);

    //查询全部课程
    List<Course> findAllCourse();

    //分页模糊查询课程
    Page<Course> findAllCourseByPageLike(int currentPage, int pageSize, String key);

    //模糊查询课程
    List<Course> findAllCourseByLike(String key);

    //判断是否有此名称的课程
    Course findCrouseByName(String cName);

    //根据类别编号查看课程
    Page<Course> findAllCourseByKind(int currentPage, int pageSize, int kindId);

    //添加课程
    boolean addCourse(Course course);

    //修改课程
    boolean updateCourse(Course course);

    //删除课程
    boolean delCourse(int cId);
}

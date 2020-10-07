package com.goodstudy.service.impl;

import com.goodstudy.dao.CourseDao;
import com.goodstudy.dao.impl.CourseDaoImpl;
import com.goodstudy.domain.Course;
import com.goodstudy.service.CourseService;
import com.goodstudy.util.Page;

import java.util.List;

/**
 * 作者:wh
 * 课程service实现
 */
public class CourseServiceImpl implements CourseService {

    private CourseDao dao = new CourseDaoImpl();

    /**
     * 分页查看全部课程
     *
     * @param currentPage 当前页
     * @param pageSize    一页显示多少记录
     * @return Page<Course> 对象
     */
    @Override
    public Page<Course> findAllCourseByPage(int currentPage, int pageSize) {
        return dao.findAllCourseByPage(currentPage, pageSize);
    }

    /**
     * 查看全部课程
     *
     * @return List<Course> 集合
     */
    @Override
    public List<Course> findAllCourse() {
        return dao.findAllCourse();
    }

    /**
     * 分页 课程名称模糊查询查看所有信息
     *
     * @param currentPage 当前页
     * @param pageSize    一页显示多少记录
     * @param key         关键字
     * @return Page<Course> 对象
     */
    @Override
    public Page<Course> findAllCourseByPageLike(int currentPage, int pageSize, String key) {
        return dao.findAllCourseByPageLike(currentPage,pageSize,key);
    }

    /**
     * 课程名称模糊查询 查看所有信息
     *
     * @param key 关键字
     * @return List<Course> 集合
     */
    @Override
    public List<Course> findAllCourseByLike(String key) {
        return dao.findAllCourseByLike(key);
    }

    /**
     * 根据教师编号分页查询课程列表
     * @param currentPage 当前页
     * @param pageSize 每页显示的记录数
     * @param tId 教师编号
     * @return
     */
    @Override
    public Page<Course> findCourseByTIdByPage(int currentPage, int pageSize, int tId) {
        return dao.findCourseByTIdByPage(currentPage,pageSize,tId);
    }

    /**
     * 查看是否有此名称的课程信息
     *
     * @param cName 课程名
     * @return Course 对象
     */
    @Override
    public Course findCrouseByName(String cName) {
        return dao.findCrouseByName(cName);
    }

    /**
     * 分页 根据类别编号查看课程信息
     *
     * @param currentPage 当前页
     * @param pageSize    一页显示多少记录
     * @param kindId      类别编号
     * @return Page<Course> 对象
     */
    @Override
    public Page<Course> findAllCourseByKind(int currentPage, int pageSize, int kindId) {
        return dao.findAllCourseByKind(currentPage,pageSize,kindId);
    }

    /**
     * 添加课程
     * 添加前进行了课程名是否重复的判断
     *
     * @param course 课程对象
     * @return 布尔
     */
    @Override
    public boolean addCourse(Course course) {
        Course crouseByName = dao.findCrouseByName(course.getcName());
        if(crouseByName != null){
            return false;
        }else{
            return dao.addCourse(course);
        }
    }

    /**
     * 根据课程编号进行修改课程
     * 可修改 缩略图 简介 价格
     *
     * @param course 课程对象
     * @return 布尔
     */
    @Override
    public boolean updateCourse(Course course) {
        return dao.updateCourse(course);
    }

    /**
     * 根据课程编号进行删除课程
     * 将课程的状态信息改为2
     *
     * @param cId 课程编号
     * @return 布尔
     */
    @Override
    public boolean delCourse(int cId) {
        return dao.delCourse(cId);
    }
}

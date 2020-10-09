package com.goodstudy.service.impl;

import com.goodstudy.dao.CourseInfoDao;
import com.goodstudy.dao.impl.CourseInfoDaoImpl;
import com.goodstudy.domain.CourseInfo;
import com.goodstudy.domain.Student;
import com.goodstudy.service.CourseInfoService;
import com.goodstudy.util.Page;

import java.util.List;
/*
*课程详情CourseInfoDao的实现
* 孙向锋
* */
public class CourseInfoServiceImpl implements CourseInfoService {

    //创建dao实例对象
CourseInfoDao courseInfoDao = new CourseInfoDaoImpl();

    @Override//增加课程详情
    public boolean addCourseInfo(CourseInfo courseInfo) {
        //判断当前录入的员工信息是否已经存在id
        CourseInfo courseInfoById = courseInfoDao.selectById(courseInfo.getInfoId());
        if(courseInfoById != null){
            return false;
        }else{
            return courseInfoDao.insert(courseInfo);
        }

    }
    /**
     * 根据id查询课程详情信息
     * @param infoId
     * @return
     */
    @Override
    public CourseInfo findById(int infoId) {
        return courseInfoDao.selectById(infoId);
    }
    /**
     * 修改课程详情信息
     * @param courseInfo
     * @return
     */
    @Override
    public boolean changeCourseInfo(CourseInfo courseInfo) {
        return courseInfoDao.update(courseInfo);
    }
    /**
     * 根据id删除课程详情信息
     * @param infoId
     * @return
     */
    @Override//根据id删除
    public boolean removeCourseInfo(int infoId) {
        return this.courseInfoDao.delete(infoId);
    }
    /**
     * 无分页查询全部课程详情
     * @return List<CourseInfo> 集合对象
     */
    @Override
    public List<CourseInfo> findAllCourseInfo() {
        return courseInfoDao.selectAll();
    }
    /**
     * 分页 查询全部课程详情信息
     * @param currentPage 当前页
     * @param pageSize    一页显示多少记录
     * @return Page<Course> 对象
     */
    @Override
    public Page<CourseInfo> findByPage(int currentPage, int pageSize) {
        return this.findByPage(currentPage,pageSize);
    }

    /**
     * 根据课程状态分页查询课程详情列表
     * @param infoState
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page<CourseInfo> findCrouseInfoByStateAndPage(int infoState, int currentPage, int pageSize) {
        return courseInfoDao.findCrouseInfoByStateAndPage(infoState, currentPage, pageSize);
    }

    /**
     * 根据课程编号修改课程状态
     * @param courseInfo
     * @return
     */
    @Override
    public boolean updateCourseInfoStateById(CourseInfo courseInfo) {
        return courseInfoDao.updateCourseInfoStateById(courseInfo);
    }

    /**
     *根据章节编号查询课程详情列表
     * @param sId
     * @return
     */
    @Override
    public List<CourseInfo> selectBysId(int sId) {
        return courseInfoDao.selectBysId(sId);
    }


}

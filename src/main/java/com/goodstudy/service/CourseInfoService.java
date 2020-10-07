package com.goodstudy.service;

import com.goodstudy.domain.CourseInfo;
import com.goodstudy.util.Page;

import java.util.List;
/*
 * 孙向锋
 * */
public interface CourseInfoService {
    //新增课程详情
    boolean addCourseInfo(CourseInfo courseInfo);
    //根据id查找
    CourseInfo findById(int infoId);
    //修改课程详情信息
    boolean changeCourseInfo(CourseInfo courseInfo );
    //删除课程详情
    boolean removeCourseInfo(int infoId);
    //查询全部课程信息
    List<CourseInfo> findAllCourseInfo();
    //分页查询操作
    Page<CourseInfo> findByPage(int currentPage,int pageSize);
    //分页查询操作
    Page<CourseInfo> findCrouseInfoByStateAndPage(int infoState,int currentPage,int pageSize);
    //通过编号修改课程状态
    boolean updateCourseInfoStateById(CourseInfo courseInfo);
}

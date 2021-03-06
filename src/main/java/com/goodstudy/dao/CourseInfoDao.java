package com.goodstudy.dao;

import com.goodstudy.domain.CourseInfo;
import com.goodstudy.util.Page;

import java.util.List;

/*课程详情Dao
 * 孙向锋
 * */
public interface CourseInfoDao {
    //查询全部课程详情
    Page<CourseInfo> selectAll(int currentPage, int pageSize);

    //无分页查询全部课程详情信息
    List<CourseInfo> selectAll();

    //按照课程编号查询该课程信息
    CourseInfo selectById(int infoId);

    //按照章节编号查询该课程列表
    List<CourseInfo> selectBysId(int sId);

    //按照章节编号分页查询该课程列表
    Page<CourseInfo> selectBySIdAndPage(int currentPage,int pageSize,int sId);

    //添加课程详情
    boolean insert(CourseInfo courseInfo);

    //根据id删除课程详情
    boolean delete(int infoId);

    //修改课程信息
    boolean update(CourseInfo courseInfo);

    //分页查询操作
    Page<CourseInfo> findCrouseInfoByStateAndPage(int infoState, int currentPage, int pageSize);

    //通过编号修改课程状态
    boolean updateCourseInfoStateById(CourseInfo courseInfo);

}

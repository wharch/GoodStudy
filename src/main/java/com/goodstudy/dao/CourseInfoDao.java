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
//按照课程编号查询该课程所有状态
CourseInfo selectById(int infoId);
//添加课程详情
boolean insert(CourseInfo courseInfo);
//根据id删除课程详情
boolean delete(int infoId);
//修改课程信息
boolean update(CourseInfo courseInfo);

}

package com.goodstudy.dao.impl;

import com.goodstudy.dao.CourseInfoDao;
import com.goodstudy.domain.Course;
import com.goodstudy.domain.CourseInfo;
import com.goodstudy.domain.Section;
import com.goodstudy.util.DBUtil;
import com.goodstudy.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
* 孙向锋
* CourseInfoDao
* */
public class CourseInfoDaoImpl implements CourseInfoDao {
    /**
     * 分页查看全部课程详情
     * @param currentPage 当前页
     * @param pageSize    一页显示多少记录
     * @return page<CourseInfo> 对象
     */
    @Override
    public Page<CourseInfo> selectAll(int currentPage, int pageSize) {
        String sql = "select * from course_info";
        Page page = DBUtil.doQueryByPage(sql, currentPage, pageSize);
        ResultSet rs = page.getRs();
        List<CourseInfo> courseInfo = new ArrayList<CourseInfo>();
        try {
            while (rs.next()) {
                courseInfo.add(new CourseInfo(
                        rs.getInt("info_id"),
                        rs.getString("video"),
                        rs.getString("note"),
                        new Section(rs.getInt("section_id")),
                        new Course(rs.getInt("c_id")),
                        rs.getInt("info_state")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        page.setData(courseInfo);
        return page;
    }
    /**
     * 查看全部课程详情
     * @return List<CourseInfo> 集合对象
     */
    @Override
    public List<CourseInfo> selectAll() {
        ResultSet rs = DBUtil.doQuery("select * from course_info");
        List<CourseInfo> courseInfo = new ArrayList<CourseInfo>();
        try {
            while (rs.next()) {
                courseInfo.add(new CourseInfo(
                        rs.getInt("info_id"),
                        rs.getString("video"),
                        rs.getString("note"),
                        new Section(rs.getInt("section_id")),
                        new Course(rs.getInt("c_id")),
                        rs.getInt("info_state")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return courseInfo;
    }
    /**
     * 根据课程详情编号查询课程详情
     * @param infoId 课程详情编号
     * @return
     */
    @Override
    public CourseInfo selectById(int infoId) {
        ResultSet rs = DBUtil.doQuery("select * from course_info where info_id=?", infoId);
        try {
            while (rs.next()) {
                return new CourseInfo(rs.getInt("info_id"),
                        rs.getString("video"),
                        rs.getString("note"),
                        new Section(rs.getInt("section_id")),
                        new Course(rs.getInt("c_id")),
                        rs.getInt("info_state"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
    /**
     * 添加课程详情
     * @param courseInfo 课程详情对象
     * @return 布尔
     */
    @Override
    public boolean insert(CourseInfo courseInfo) {
        int i = DBUtil.doUpdate("insert into course_info(info_id,video,note,section_id,c_id,info_state)values(?,?,?,?,?,?)",
                courseInfo.getInfoId(),courseInfo.getVideo(),courseInfo.getNote(),courseInfo.getSection(),courseInfo.getCourse(),courseInfo.getInfoState());
        return i>1?true:false;
    }
    /**
     * 删除课程详情
     *
     * @param infoId 对象
     * @return 布尔
     */
    @Override
    public boolean delete(int infoId) {
        //执行sql语句并且获取里面？的值
        int i = DBUtil.doUpdate("delete from course_info where info_id=?",infoId);
        //返回i
        return i>0?true:false;
    }
    /**
     * 修改课程详情
     *
     * @param courseInfo 对象
     * @return 布尔
     */
    @Override
    public boolean update(CourseInfo courseInfo) {
        //执行sql语句并且获取里面？的值
        int i = DBUtil.doUpdate("update course_info set video=?,note=?,section_id=?,c_id=?,info_state=?where info_id=?",
                courseInfo.getVideo(),courseInfo.getNote(),courseInfo.getSection(),courseInfo.getCourse(),courseInfo.getInfoState());
        //返回i
        return i>0?true:false;
    }
}

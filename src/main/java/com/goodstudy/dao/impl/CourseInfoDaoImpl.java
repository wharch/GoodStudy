package com.goodstudy.dao.impl;

import com.goodstudy.dao.CourseInfoDao;
import com.goodstudy.domain.Course;
import com.goodstudy.domain.CourseInfo;
import com.goodstudy.domain.Section;
import com.goodstudy.domain.Teacher;
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
     *
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
                        rs.getString("knobble_name"),
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
     *
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
                        rs.getString("knobble_name"),
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
     *
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
                        rs.getString("knobble_name"),
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
     * 根据章节编号不分页查询课程详情列表
     * @param sId
     * @return
     */
    @Override
    public List<CourseInfo> selectBysId(int sId) {
        String sql = "select * from course_info where section_id = ?";
        ResultSet rs = DBUtil.doQuery(sql, sId);
        List<CourseInfo> courseInfos = new ArrayList<>();
        try {
            while (rs.next()) {
                int infoId = rs.getInt("info_id");
                String video = rs.getString("video");
                String note = rs.getString("note");
                String knobbleName = rs.getString("knobble_name");
                int cId = rs.getInt("c_id");
                int infoState = rs.getInt("info_state");
                CourseInfo courseInfo = new CourseInfo(infoId,video,note,knobbleName,new Section(sId,null,null),null,infoState);
                courseInfos.add(courseInfo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return courseInfos;
    }

    /**
     * 添加课程详情
     *
     * @param courseInfo 课程详情对象
     * @return 布尔
     */
    @Override
    public boolean insert(CourseInfo courseInfo) {
        int i = DBUtil.doUpdate("insert into course_info values(null,?,?,?,?,?,2)",
                courseInfo.getVideo(), courseInfo.getNote(), courseInfo.getKnobbleName(), courseInfo.getSection().getSectionId(), courseInfo.getCourse().getcId());
        return i > 0 ? true : false;
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
        int i = DBUtil.doUpdate("delete from course_info where info_id=?", infoId);
        //返回i
        return i > 0 ? true : false;
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
                courseInfo.getVideo(), courseInfo.getNote(), courseInfo.getSection(), courseInfo.getCourse(), courseInfo.getInfoState());
        //返回i
        return i > 0 ? true : false;
    }

    @Override
    public Page<CourseInfo> findCrouseInfoByStateAndPage(int infoState, int currentPage, int pageSize) {
        String sql = "select course_info.info_id,course_info.video,course_info.note,course_info.knobble_name,course_info.info_state,inf.section_id,inf.section_name,inf.c_id,inf.c_name,inf.t_name from course_info inner join (select section.section_id,section.section_name,section.c_id,co.c_name,co.t_name from section inner join (select course.c_id,course.c_name,teacher.t_name from course  inner join teacher on course.t_id = teacher.t_id) as co on section.c_id=co.c_id) as inf on course_info.section_id=inf.section_id where course_info.info_state=?";
        Page<CourseInfo> page = DBUtil.doQueryByPage(sql, currentPage, pageSize, infoState);
        ResultSet rs = page.getRs();
        List<CourseInfo> courseInfos = new ArrayList<>();
        try {
            while (rs.next()){
                int infoId = rs.getInt("info_id");
                String video = rs.getString("video");
                String note = rs.getString("note");
                String knobbleName = rs.getString("knobble_name");
                String sectionName = rs.getString("section_name");
                String cName = rs.getString("c_name");
                String tName = rs.getString("t_name");
                CourseInfo courseInfo = new CourseInfo(infoId,video,note,knobbleName,new Section(0,sectionName,new Course(0,cName,null,new Teacher(tName),null,null,0,0)),null,infoState);
                courseInfos.add(courseInfo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        page.setData(courseInfos);
        return page;
    }

    @Override
    public boolean updateCourseInfoStateById(CourseInfo courseInfo) {
        String sql = "update course_info set info_state=? where info_id = ?";
        return DBUtil.doUpdate(sql,courseInfo.getInfoState(),courseInfo.getInfoId())>0;
    }

}

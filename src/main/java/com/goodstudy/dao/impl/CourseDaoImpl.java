package com.goodstudy.dao.impl;

import com.goodstudy.dao.CourseDao;
import com.goodstudy.domain.Course;
import com.goodstudy.domain.Kind;
import com.goodstudy.domain.Teacher;
import com.goodstudy.util.DBUtil;
import com.goodstudy.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者:wh
 * 课程dao实现
 */
public class CourseDaoImpl implements CourseDao {

    /**
     * 分页查看全部课程
     *
     * @param currentPage 当前页
     * @param pageSize    一页显示多少记录
     * @return page<Course> 对象
     */
    @Override
    public Page<Course> findAllCourseByPage(int currentPage, int pageSize) {
        String sql = "select c.c_id,c.c_master,c.c_name,c.c_price,c.c_status,c.c_info,t.t_id,t.t_name,t.t_phone,k.kind_id,k.kind_name from course c inner join  kind k ON c.kind_id=k.kind_id left join teacher t ON t.t_id=c.t_id";
        Page<Course> page = DBUtil.doQueryByPage(sql, currentPage, pageSize);
        ResultSet rs = page.getRs();
        List<Course> courses = new ArrayList<>();
        try {
            while (rs.next()) {
                int cId = rs.getInt("c_id");
                String cMaster = rs.getString("c_master");
                String cName = rs.getString("c_name");
                double cPrice = rs.getDouble("c_price");
                int cStatus = rs.getInt("c_status");
                String cInfo = rs.getString("c_info");
                int tId = rs.getInt("t_id");
                String tName = rs.getString("t_name");
                String tPhone = rs.getString("t_phone");
                int kindId = rs.getInt("kind_id");
                String kindName = rs.getString("kind_name");
                Kind kind = new Kind(kindId, kindName);
                Teacher teacher = new Teacher(tId, tName, null, null, tPhone, null, null, null, null, 0, 0, null, null);
                Course course = new Course(cId, cName, kind, teacher, cMaster, cInfo, cPrice, cStatus);
                courses.add(course);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        page.setData(courses);
        return page;
    }

    /**
     * 查看全部课程
     *
     * @return List<Course> 集合
     */
    @Override
    public List<Course> findAllCourse() {
        String sql = "select c.c_id,c.c_master,c.c_name,c.c_price,c.c_status,c.c_info,t.t_id,t.t_name,t.t_phone,k.kind_id,k.kind_name from course c inner join  kind k ON c.kind_id=k.kind_id left join teacher t ON t.t_id=c.t_id";
        ResultSet rs = DBUtil.doQuery(sql);
        List<Course> courses = new ArrayList<>();
        try {
            while (rs.next()) {
                int cId = rs.getInt("c_id");
                String cMaster = rs.getString("c_master");
                String cName = rs.getString("c_name");
                double cPrice = rs.getDouble("c_price");
                int cStatus = rs.getInt("c_status");
                String cInfo = rs.getString("c_info");
                int tId = rs.getInt("t_id");
                String tName = rs.getString("t_name");
                String tPhone = rs.getString("t_phone");
                int kindId = rs.getInt("kind_id");
                String kindName = rs.getString("kind_name");
                Kind kind = new Kind(kindId, kindName);
                Teacher teacher = new Teacher(tId, tName, null, null, tPhone, null, null, null, null, 0, 0, null, null);
                Course course = new Course(cId, cName, kind, teacher, cMaster, cInfo, cPrice, cStatus);
                courses.add(course);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return courses;
    }

    /**
     * 根据课程名模糊查询全部信息
     *
     * @param currentPage 当前页
     * @param pageSize    一页显示多少记录
     * @param key         关键字要查询的关键字
     * @return page<Course> 对象
     */
    @Override
    public Page<Course> findAllCourseByPageLike(int currentPage, int pageSize, String key) {
        String sql = "select c.c_id,c.c_master,c.c_name,c.c_price,c.c_status,c.c_info,t.t_id,t.t_name,t.t_phone,k.kind_id,k.kind_name from course c inner join  kind k ON c.kind_id=k.kind_id left join teacher t ON t.t_id=c.t_id where c.c_name like ?";
        Page<Course> page = DBUtil.doQueryByPage(sql, currentPage, pageSize, "%" + key + "%");
        ResultSet rs = page.getRs();
        List<Course> courses = new ArrayList<>();
        try {
            while (rs.next()) {
                int cId = rs.getInt("c_id");
                String cMaster = rs.getString("c_master");
                String cName = rs.getString("c_name");
                double cPrice = rs.getDouble("c_price");
                int cStatus = rs.getInt("c_status");
                String cInfo = rs.getString("c_info");
                int tId = rs.getInt("t_id");
                String tName = rs.getString("t_name");
                String tPhone = rs.getString("t_phone");
                int kindId = rs.getInt("kind_id");
                String kindName = rs.getString("kind_name");
                Kind kind = new Kind(kindId, kindName);
                Teacher teacher = new Teacher(tId, tName, null, null, tPhone, null, null, null, null, 0, 0, null, null);
                Course course = new Course(cId, cName, kind, teacher, cMaster, cInfo, cPrice, cStatus);
                courses.add(course);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        page.setData(courses);
        return page;
    }

    /**
     * 根据课程名模糊查询全部信息
     *
     * @param key 关键字
     * @return List<Course> 对象
     */
    @Override
    public List<Course> findAllCourseByLike(String key) {
        String sql = "select c.c_id,c.c_master,c.c_name,c.c_price,c.c_status,c.c_info,t.t_id,t.t_name,t.t_phone,k.kind_id,k.kind_name from course c inner join  kind k ON c.kind_id=k.kind_id left join teacher t ON t.t_id=c.t_id where c.c_name like ?";
        ResultSet rs = DBUtil.doQuery(sql, "%" + key + "%");
        List<Course> courses = new ArrayList<>();
        try {
            while (rs.next()) {
                int cId = rs.getInt("c_id");
                String cMaster = rs.getString("c_master");
                String cName = rs.getString("c_name");
                double cPrice = rs.getDouble("c_price");
                int cStatus = rs.getInt("c_status");
                String cInfo = rs.getString("c_info");
                int tId = rs.getInt("t_id");
                String tName = rs.getString("t_name");
                String tPhone = rs.getString("t_phone");
                int kindId = rs.getInt("kind_id");
                String kindName = rs.getString("kind_name");
                Kind kind = new Kind(kindId, kindName);
                Teacher teacher = new Teacher(tId, tName, null, null, tPhone, null, null, null, null, 0, 0, null, null);
                Course course = new Course(cId, cName, kind, teacher, cMaster, cInfo, cPrice, cStatus);
                courses.add(course);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return courses;
    }

    /**
     * 根据教师编号分页查询课程列表
     * @param currentPage 当前页
     * @param pageSize 每页显示的数量
     * @param tId 教师编号
     * @return
     */
    @Override
    public Page<Course> findCourseByTIdByPage(int currentPage, int pageSize, int tId) {
        String sql = "select c.c_id,c.c_master,c.c_name,c.c_price,c.c_status,c.c_info,t.t_id,t.t_name,t.t_phone,k.kind_id,k.kind_name from course c inner join  kind k ON c.kind_id=k.kind_id left join teacher t ON t.t_id=c.t_id where c.t_id = ?";
        Page<Course> page = DBUtil.doQueryByPage(sql, currentPage, pageSize, tId);
        ResultSet rs = page.getRs();
        List<Course> courses = new ArrayList<>();
        try {
            while (rs.next()) {
                int cId = rs.getInt("c_id");
                String cMaster = rs.getString("c_master");
                String cName = rs.getString("c_name");
                double cPrice = rs.getDouble("c_price");
                int cStatus = rs.getInt("c_status");
                String cInfo = rs.getString("c_info");
                String tName = rs.getString("t_name");
                String tPhone = rs.getString("t_phone");
                int kindId = rs.getInt("kind_id");
                String kindName = rs.getString("kind_name");
                Kind kind = new Kind(kindId, kindName);
                Teacher teacher = new Teacher(tId, tName, null, null, tPhone, null, null, null, null, 0, 0, null, null);
                Course course = new Course(cId, cName, kind, teacher, cMaster, cInfo, cPrice, cStatus);
                courses.add(course);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        page.setData(courses);
        return page;
    }

    /**
     * 根据名称查看是否有此课程
     *
     * @param cName 课程名称
     * @return Course 对象
     */
    @Override
    public Course findCrouseByName(String cName) {
        String sql = "select * from course where c_name = ?";
        ResultSet rs = DBUtil.doQuery(sql, cName);
        Course course = null;
        try {
            if (rs.next()) {
                int cId = rs.getInt("c_id");
                String cMaster = rs.getString("c_master");
                double cPrice = rs.getDouble("c_price");
                int cStatus = rs.getInt("c_status");
                String cInfo = rs.getString("c_info");
                int tId = rs.getInt("t_id");
                int kindId = rs.getInt("kind_id");
                Kind kind = new Kind(kindId, null);
                Teacher teacher = new Teacher(tId, null, null, null, null, null, null, null, null, 0, 0, null, null);
                course = new Course(cId, cName, kind, teacher, cMaster, cInfo, cPrice, cStatus);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return course;
    }

    /**
     * 分页根据类型查看全部信息
     *
     * @param currentPage 当前页
     * @param pageSize    一页显示多少记录
     * @param kindId      类型编号
     * @return Page<Course> 对象
     */
    @Override
    public Page<Course> findAllCourseByKind(int currentPage, int pageSize, int kindId) {
        String sql = "select c.c_id,c.c_master,c.c_name,c.c_price,c.c_status,c.c_info,t.t_id,t.t_name,t.t_phone,k.kind_id,k.kind_name from course c inner join  kind k ON c.kind_id=k.kind_id left join teacher t ON t.t_id=c.t_id where c.kind_id = ?";
        Page<Course> page = DBUtil.doQueryByPage(sql, currentPage, pageSize, kindId);
        ResultSet rs = page.getRs();
        List<Course> courses = new ArrayList<>();
        try {
            while (rs.next()) {
                int cId = rs.getInt("c_id");
                String cMaster = rs.getString("c_master");
                String cName = rs.getString("c_name");
                double cPrice = rs.getDouble("c_price");
                int cStatus = rs.getInt("c_status");
                String cInfo = rs.getString("c_info");
                int tId = rs.getInt("t_id");
                String tName = rs.getString("t_name");
                String tPhone = rs.getString("t_phone");
                String kindName = rs.getString("kind_name");
                Kind kind = new Kind(kindId, kindName);
                Teacher teacher = new Teacher(tId, tName, null, null, tPhone, null, null, null, null, 0, 0, null, null);
                Course course = new Course(cId, cName, kind, teacher, cMaster, cInfo, cPrice, cStatus);
                courses.add(course);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        page.setData(courses);
        return page;
    }

    /**
     * 添加课程
     *
     * @param course 课程对象
     * @return 布尔
     */
    @Override
    public boolean addCourse(Course course) {
        String sql = "insert into course values(null,?,?,?,?,?,?,1)";
        return DBUtil.doUpdate(sql, course.getcName(), course.getKind().getKindId(), course.getTeacher().gettId(), course.getcMaster(), course.getcInfo(), course.getcPrice()) > 0;
    }

    /**
     * 通过课程编号修改课程
     * 可修改 缩略图 简介 价格
     *
     * @param course 课程对象
     * @return 布尔
     */
    @Override
    public boolean updateCourse(Course course) {
        String sql = "update course set c_master=?,c_info=?,c_price=? where c_id=?";
        return DBUtil.doUpdate(sql, course.getcMaster(), course.getcInfo(), course.getcPrice(), course.getcId()) > 0;
    }

    /**
     * 1为正常 2为下架状态
     * 根据课程编号删除课程 将课程状态修改为2
     *
     * @param cId 课程编号
     * @return 布尔
     */
    @Override
    public boolean delCourse(int cId) {
        String sql = "update course set c_status=2 where c_id=?";
        return DBUtil.doUpdate(sql, cId) > 0;
    }
}

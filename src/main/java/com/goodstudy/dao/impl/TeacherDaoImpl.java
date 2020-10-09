package com.goodstudy.dao.impl;

import com.goodstudy.dao.TeacherDao;
import com.goodstudy.domain.Teacher;
import com.goodstudy.util.DBUtil;
import com.goodstudy.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 教师teacherDao的实现
 * @author 刘美琦
 */
public class TeacherDaoImpl implements TeacherDao {
    /**
     * 添加一个老师
     * @param teacher
     * @return
     */
    @Override
    public boolean insertTeacher(Teacher teacher) {
        String sql = "insert into teacher values(?,?,?,?,?,?,?,?,?,2,2,?,?)";
        int i = DBUtil.doUpdate(sql, teacher.gettId(), teacher.gettName(), teacher.gettGender(), teacher.getHiredate(), teacher.gettPhone(), teacher.gettInfo(), teacher.gettUsername(), teacher.gettPwd(), teacher.gettHeadImg(),teacher.getCertificate(),teacher.getCertificateImg());
        return i>0?true:false;
    }

    /**
     * 根据教师编号删除教师
     * @param tId
     * @return
     */
    @Override
    public boolean deleteTeacher(int tId) {
        String sql = "delete from teacher where t_id = ? ";
        int i = DBUtil.doUpdate(sql, tId);
        return i>0?true:false;
    }

    /**
     * 根据教师编号更新教师的个人资料
     * @param teacher
     * @return
     */
    @Override
    public boolean updateTeacher(Teacher teacher) {
        String sql = "update teacher set t_name = ?,t_gender = ?,hiredate = ?,t_phone = ?,t_info = ?,t_pwd = ?,t_head_img = ? where t_id = ?";
        int i = DBUtil.doUpdate(sql, teacher.gettName(), teacher.gettGender(), teacher.getHiredate(), teacher.gettPhone(), teacher.gettInfo(), teacher.gettPwd(), teacher.gettHeadImg(), teacher.gettId());
        return i>0?true:false;
    }

    /**
     * 根据教师的编号更新教师的审核状态
     * @param tId
     * @param tState
     * @return
     */
    @Override
    public boolean updateTeacherStatus(int tId,int tState) {
        String sql = "update teacher set t_state = ? where t_id = ?";
        int i = DBUtil.doUpdate(sql, tState, tId);
        return i>0?true:false;
    }

    /**
     * 根据用户名和密码查询该教师是否存在，用于教师登录
     * @param tUsername
     * @param tPwd
     * @return
     */
    @Override
    public Teacher selectTeacherByUnameAndPwd(String tUsername, String tPwd) {
        String sql = "select * from teacher where t_username = ? and t_pwd = ? ";
        ResultSet rs = DBUtil.doQuery(sql, tUsername, tPwd);
        Teacher teacher = null;
        try {
            if(rs.next()){
                int tId = rs.getInt("t_id");
                String tName = rs.getString("t_name");
                String tGender = rs.getString("t_gender");
                String hiredate = rs.getString("hiredate");
                String tPhone = rs.getString("t_phone");
                String tInfo = rs.getString("t_info");
                String tHeadImg = rs.getString("t_head_img");
                int role = rs.getInt("role");
                int tState = rs.getInt("t_state");
                String certificate = rs.getString("certificate");
                String certificateImg = rs.getString("certificate_img");
                teacher = new Teacher(tId,tName,tGender,hiredate,tPhone,tInfo,tUsername,tPwd,tHeadImg,role,tState,certificate,certificateImg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    /**
     * 根据教师的手机号和密码以及状态查询教师是否存在以及正常（登录）
     * @param tPhone
     * @param tPwd
     * @return
     */
    @Override
    public Teacher selectTeacherByPhoneAndPwd(String tPhone, String tPwd) {
        String sql = "select * from teacher where t_phone = ? and t_pwd = ? ";
        ResultSet rs = DBUtil.doQuery(sql, tPhone, tPwd);
        Teacher teacher = null;
        try {
            if(rs.next()){
                int tId = rs.getInt("t_id");
                String tName = rs.getString("t_name");
                String tGender = rs.getString("t_gender");
                String hiredate = rs.getString("hiredate");
                String tInfo = rs.getString("t_info");
                String tUsername = rs.getString("t_username");
                String tHeadImg = rs.getString("t_head_img");
                int role = rs.getInt("role");
                int tState = rs.getInt("t_state");
                String certificate = rs.getString("certificate");
                String certificateImg = rs.getString("certificate_img");
                teacher = new Teacher(tId,tName,tGender,hiredate,tPhone,tInfo,tUsername,tPwd,tHeadImg,role,tState,certificate,certificateImg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    /**
     * 根据手机号查询教师对象（注册的手机号不可重复）
     * @param tPhone
     * @return
     *
     */
    @Override
    public Teacher selectTeacherByPhone(String tPhone) {
        String sql = "select * from teacher where t_phone = ? and role = 2";
        ResultSet rs = DBUtil.doQuery(sql, tPhone);
        Teacher teacher = null;
        try {
            if(rs.next()){
                int tId = rs.getInt("t_id");
                String tName = rs.getString("t_name");
                String tGender = rs.getString("t_gender");
                String hiredate = rs.getString("hiredate");
                String tInfo = rs.getString("t_info");
                String tUsername = rs.getString("t_username");
                String tPwd = rs.getString("t_pwd");
                String tHeadImg = rs.getString("t_head_img");
                int role = rs.getInt("role");
                int tState = rs.getInt("t_state");
                String certificate = rs.getString("certificate");
                String certificateImg = rs.getString("certificate_img");
                teacher = new Teacher(tId,tName,tGender,hiredate,tPhone,tInfo,tUsername,tPwd,tHeadImg,role,tState,certificate,certificateImg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    /**
     * 根据教师编号查询教师对象
     * @param tId
     * @return
     */
    @Override
    public Teacher selectTeacherByTId(int tId) {
        String sql = "select * from teacher where t_id = ?";
        ResultSet rs = DBUtil.doQuery(sql, tId);
        Teacher teacher = null;
        try {
            if(rs.next()){
                String tName = rs.getString("t_name");
                String tGender = rs.getString("t_gender");
                String hiredate = rs.getString("hiredate");
                String tPhone = rs.getString("t_phone");
                String tInfo = rs.getString("t_info");
                String tUsername = rs.getString("t_username");
                String tPwd = rs.getString("t_pwd");
                String tHeadImg = rs.getString("t_head_img");
                int role = rs.getInt("role");
                int tState = rs.getInt("t_state");
                String certificate = rs.getString("certificate");
                String certificateImg = rs.getString("certificate_img");
                teacher = new Teacher(tId,tName,tGender,hiredate,tPhone,tInfo,tUsername,tPwd,tHeadImg,role,tState,certificate,certificateImg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    /**
     * 分页查询所有教师
     * @return
     *
     */
    @Override
    public Page<Teacher> selectAllTeacherByPage(int currentPage,int pageSize) {
        String sql = "select * from teacher where role = 2";
        Page page = DBUtil.doQueryByPage(sql, currentPage, pageSize);
        ResultSet rs = page.getRs();
        List<Teacher> teachers = new ArrayList<>();
        try {
            while (rs.next()){
                int tId = rs.getInt("t_id");
                String tName = rs.getString("t_name");
                String tGender = rs.getString("t_gender");
                String hiredate = rs.getString("hiredate");
                String tPhone = rs.getString("t_phone");
                String tInfo = rs.getString("t_info");
                String tUsername = rs.getString("t_username");
                String tPwd = rs.getString("t_pwd");
                String tHeadImg = rs.getString("t_head_img");
                int role = rs.getInt("role");
                int tState = rs.getInt("t_state");
                String certificate = rs.getString("certificate");
                String certificateImg = rs.getString("certificate_img");
                Teacher teacher = new Teacher(tId,tName,tGender,hiredate,tPhone,tInfo,tUsername,tPwd,tHeadImg,role,tState,certificate,certificateImg);
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        page.setData(teachers);
        return page;
    }

    /**
     * 不分页查询所有教师记录
     * @return
     */
    @Override
    public List<Teacher> selectAllTeacher() {
        String sql = "select * from teacher and role = 2";
        ResultSet rs = DBUtil.doQuery(sql);
        List<Teacher> teachers = new ArrayList<>();
        try {
            while (rs.next()){
                int tId = rs.getInt("t_id");
                String tName = rs.getString("t_name");
                String tGender = rs.getString("t_gender");
                String hiredate = rs.getString("hiredate");
                String tPhone = rs.getString("t_phone");
                String tInfo = rs.getString("t_info");
                String tUsername = rs.getString("t_username");
                String tPwd = rs.getString("t_pwd");
                String tHeadImg = rs.getString("t_head_img");
                int role = rs.getInt("role");
                int tState = rs.getInt("t_state");
                String certificate = rs.getString("certificate");
                String certificateImg = rs.getString("certificate_img");
                Teacher teacher = new Teacher(tId,tName,tGender,hiredate,tPhone,tInfo,tUsername,tPwd,tHeadImg,role,tState,certificate,certificateImg);
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    /**
     * 根据教师的状态分页查询教师的列表
     * @param currentPage
     * @param pageSize
     * @param tState 教师的审核状态
     * @return
     */
    @Override
    public Page<Teacher> selectTeacherByStateByPage(int currentPage, int pageSize, int tState) {
        String sql = "select * from teacher where t_state = ? and role = 2";
        Page page = DBUtil.doQueryByPage(sql, currentPage, pageSize,tState);
        ResultSet rs = page.getRs();
        List<Teacher> teachers = new ArrayList<>();
        try {
            while (rs.next()){
                int tId = rs.getInt("t_id");
                String tName = rs.getString("t_name");
                String tGender = rs.getString("t_gender");
                String hiredate = rs.getString("hiredate");
                String tPhone = rs.getString("t_phone");
                String tInfo = rs.getString("t_info");
                String tUsername = rs.getString("t_username");
                String tPwd = rs.getString("t_pwd");
                String tHeadImg = rs.getString("t_head_img");
                int role = rs.getInt("role");
                String certificate = rs.getString("certificate");
                String certificateImg = rs.getString("certificate_img");
                Teacher teacher = new Teacher(tId,tName,tGender,hiredate,tPhone,tInfo,tUsername,tPwd,tHeadImg,role,tState,certificate,certificateImg);
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        page.setData(teachers);
        return page;
    }
}

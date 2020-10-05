package com.goodstudy.service;

import com.goodstudy.domain.Teacher;
import com.goodstudy.util.Page;

import java.util.List;

/**
 * 教师的service接口
 * @author 刘美琦
 */
public interface TeacherService {
    /**
     * 增加老师
     * 默认角色是2代表教师，默认状态是2代表未通过审核
     * @param teacher
     * @return
     */
    boolean insertTeacher(Teacher teacher);

    /**
     * 根据教师编号删除教师
     * @param tId
     * @return
     */
    boolean deleteTeacher(int tId);

    /**
     * 更新教师的个人资料
     * @param teacher
     * @return
     */
    boolean updateTeacher(Teacher teacher);

    /**
     * 根据教师编号修改教师的审核状态
     * @param tId
     * @return
     */
    boolean updateTeacherStatus(int tId,int tState);

    /**
     * 根据教师用户名和密码以及状态查询教师是否存在及正常（登录）
     * @param tUsername
     * @param tPwd
     * @return
     */
    Teacher selectTeacherByUnameAndPwd(String tUsername,String tPwd);
    /**
     * 根据教师的手机号和密码以及状态查询教师是否存在以及正常（登录）
     * @param tPhone
     * @param tPwd
     * @return
     */
    Teacher selectTeacherByPhoneAndPwd(String tPhone,String tPwd);
    /**
     * 根据教师的手机号查找教师，用于在（注册时手机号不能重复）
     * @param tPhone
     * @return
     */
    Teacher selectTeacherByPhone(String tPhone);

    /**
     * 教师登录（可以根据手机号和教师编号登录）
     * @param account
     * @param password
     * @return
     */
    Teacher teacherLogin(String account,String password);
    /**
     * 分页查询所有的教师列表（审核通过与审核失败时要用的）
     * @return
     */
    Page<Teacher> selectAllTeacherByPage(int currentPage, int pageSize);

    /**
     * 不分页查询所有的教师记录
     * @return
     */
    List<Teacher> selectAllTeacher();
}

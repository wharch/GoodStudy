package com.goodstudy.dao;

import com.goodstudy.domain.Teacher;
import com.goodstudy.util.Page;

import java.util.List;

/**
 *刘美琦
 * 教师teacher实体类的dao层
 */
public interface TeacherDao {
    /**
     * 增加老师
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
     * 根据教师编号查询教师对象
     * @param tId
     * @return
     */
    Teacher selectTeacherByTId(int tId);
    /**
     * 分页查询所有的教师列表（审核通过与审核失败时要用的）
     * @return
     */
    Page<Teacher> selectAllTeacherByPage(int currentPage,int pageSize);

    /**
     * 不分页查询所有教师列表
     * @return
     */
    List<Teacher> selectAllTeacher();
}

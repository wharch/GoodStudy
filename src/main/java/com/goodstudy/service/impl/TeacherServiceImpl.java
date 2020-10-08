package com.goodstudy.service.impl;

import com.goodstudy.dao.TeacherDao;
import com.goodstudy.dao.impl.TeacherDaoImpl;
import com.goodstudy.domain.Teacher;
import com.goodstudy.service.TeacherService;
import com.goodstudy.util.Page;
import com.goodstudy.util.RandomUtil;

import java.util.List;

/**
 * 教师的实现类
 * @author 刘美琦
 */
public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao = new TeacherDaoImpl();

    /**
     * 添加一个教师
     * role :默认角色 2--教师
     * t_state :默认状态 2--审核未通过
     * t_username:自动生成的一个随机的编号
     * t_id:默认id是自增字段
     * 需要判断手机号不可以为重复字段
     * @param teacher
     * @return
     */
    @Override
    public boolean insertTeacher(Teacher teacher) {
        // 设置角色和状态的默认值
        teacher.setRole(2);
        teacher.settState(2);
        //设置一个随机的用户名
        teacher.settUsername(RandomUtil.randomTUsername());
        if(teacherDao.selectTeacherByPhone(teacher.gettPhone()) == null){
            return teacherDao.insertTeacher(new Teacher(0, teacher.gettName(), teacher.gettGender(), teacher.getHiredate(), teacher.gettPhone(), teacher.gettInfo(), teacher.gettUsername(), teacher.gettPwd(), teacher.gettHeadImg(), teacher.getRole(), teacher.gettState(), teacher.getCertificate(), teacher.getCertificateImg()));
        }
        return false;
    }

    /**
     * 根据教师的编号删除教师
     * @param tId
     * @return
     */
    @Override
    public boolean deleteTeacher(int tId) {
        return teacherDao.deleteTeacher(tId);
    }

    /**
     * 教师个人修改教师的个人资料
     * 教师名，教师性别，电话，教师简介，密码，头像
     * @param teacher
     * @return
     */
    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherDao.updateTeacher(teacher);
    }

    /**
     * 修改教师的审核状态
     * 当教师的状态为审核通过状态，改为审核不通过
     * 当教师的状态为审核未通过，改为审核通过
     * @param tId
     * @param tState
     * @return
     */
    @Override
    public boolean updateTeacherStatus(int tId, int tState) {
        if(tState == 1){
            return teacherDao.updateTeacherStatus(tId,2);
        }else if(tState == 2){
            return teacherDao.updateTeacherStatus(tId,1);
        }
        return false;
    }

    /**
     * 根据教师的用户名（账号）和密码查找教师
     * @param tUsername
     * @param tPwd
     * @return
     */
    @Override
    public Teacher selectTeacherByUnameAndPwd(String tUsername, String tPwd) {
        return teacherDao.selectTeacherByUnameAndPwd(tUsername,tPwd);
    }

    /**
     * 根据教师的手机号和密码查找教师
     * @param tPhone
     * @param tPwd
     * @return
     */
    @Override
    public Teacher selectTeacherByPhoneAndPwd(String tPhone, String tPwd) {
        return teacherDao.selectTeacherByPhoneAndPwd(tPhone,tPwd);
    }

    /**
     * 根据手机号查询教师对象
     * @param tPhone
     * @return
     */
    @Override
    public Teacher selectTeacherByPhone(String tPhone) {
        return teacherDao.selectTeacherByPhone(tPhone);
    }

    /**
     * 根据教师编号查询教师记录
     * @param tId
     * @return
     */
    @Override
    public Teacher selectTeacherByTId(int tId) {
        return teacherDao.selectTeacherByTId(tId);
    }

    /**
     * 根据教师用户名（账号）/手机号以及相应密码查找教师对象从而进行登录
     * @param account
     * @param password
     * @return
     */
    @Override
    public Teacher teacherLogin(String account, String password) {
        Teacher teacherByPhoneAndPwd = teacherDao.selectTeacherByPhoneAndPwd(account, password);
        Teacher teacherByUnameAndPwd = teacherDao.selectTeacherByUnameAndPwd(account, password);
        if( teacherByPhoneAndPwd != null){
            return teacherByPhoneAndPwd;
        }else if(teacherByUnameAndPwd != null){
           return teacherByUnameAndPwd;
        }
        return null;
    }

    /**
     * 分页查询教师
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page<Teacher> selectAllTeacherByPage(int currentPage, int pageSize) {
        return teacherDao.selectAllTeacherByPage(currentPage,pageSize);
    }

    /**
     * 不分页查询所有的教师记录
     * @return
     */
    @Override
    public List<Teacher> selectAllTeacher() {
        return teacherDao.selectAllTeacher();
    }

}

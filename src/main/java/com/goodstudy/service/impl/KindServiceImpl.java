package com.goodstudy.service.impl;

import com.goodstudy.dao.impl.KindDaoImpl;
import com.goodstudy.dao.KindDao;
import com.goodstudy.domain.Kind;
import com.goodstudy.domain.Student;
import com.goodstudy.service.KindService;
import com.goodstudy.util.Page;
/*
* 孙向锋
* kindServiceDao的实现
* */
public class KindServiceImpl implements KindService {
    //创建dao实例对象
    KindDao kindDao = new KindDaoImpl();
    /**
     * 添加类别信息
     * @param kind
     * @return
     */
    @Override
    public boolean addKind(Kind kind) {
        //判断当前录入的员工信息是否已经存在
        Kind kindByName = kindDao.selectByName(kind.getKindName());
        if(kindByName != null){
            return false;
        }else{
            return kindDao.insert(kind);
        }
    }
    /**
     * 根据类别名称查询课程详情信息
     * @param kindName
     * @return
     */
    @Override
    public Kind findByName(String kindName) {
        return this.kindDao.selectByName(kindName);
    }
    /**
     * 修改课程类别信息
     * @param kind
     * @return
     */
    @Override
    public boolean changeKind(Kind kind) {
        return this.kindDao.update(kind);
    }
    /**
     * 删除课程
     * @param kindName
     * @return
     */
    @Override
    public boolean removeKind(String kindName) {
        return this.kindDao.delete(kindName);
    }
    /**
     * 分页查询全部的学生信息
     * @param currentPage 当前页
     * @param pageSize 每页显示的数量
     * Page<Kind> 集合对象
     * @return
     */
    @Override
    public Page<Kind> findByPage(int currentPage, int pageSize) {
        return this.kindDao.selectAll(currentPage, pageSize);
    }
}

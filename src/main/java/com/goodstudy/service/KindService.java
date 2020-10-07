package com.goodstudy.service;

import com.goodstudy.domain.Kind;
import com.goodstudy.domain.Student;
import com.goodstudy.util.Page;

import java.util.List;

/*
 * 孙向锋
 * */
public interface KindService {
    //新增课程
    boolean addKind(Kind kind);
    //根据名称查找
    Kind findByName(String kindName);
    //修改课程信息
    boolean changeKind(Kind kind);
    //根据课程名称删除课程
    boolean removeKind(String kindName);
    //根据课程名称查找
    //分页查询
    Page<Kind> findByPage(int currentPage, int pageSize);
    //不分页查询所有的分类
    List<Kind> findAllKind();
}

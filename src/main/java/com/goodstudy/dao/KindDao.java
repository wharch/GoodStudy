package com.goodstudy.dao;

import com.goodstudy.domain.Kind;
import com.goodstudy.util.Page;

/*课程类别Dao
 * 孙向锋
 * */
public interface KindDao {
    //增加课程
    boolean insert (Kind kind);
    //根据课程名称删除课程
    boolean delete(String kindName);
    //修改课程信息
    boolean update(Kind kind);
    //查询全部课程
    Page<Kind>selectAll(int currentPage,int pageSize);
    //根据课程名称查询对应的课程信息
    Kind selectByName(String kindName);

}

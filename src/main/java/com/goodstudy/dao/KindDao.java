package com.goodstudy.dao;

import com.goodstudy.domain.Kind;
import com.goodstudy.util.Page;

import java.util.List;

/*课程类别Dao
 * 孙向锋
 * */
public interface KindDao {
    //增加课程类别
    boolean insert (Kind kind);
    //根据课程类别名称删除课程类别
    boolean delete(String kindName);
    //修改课程类别信息
    boolean update(Kind kind);
    //查询全部课程类别
    Page<Kind>selectAll(int currentPage,int pageSize);
    //根据课程名称查询对应的课程类别信息
    Kind selectByName(String kindName);
    //不分页查询所有课程类别
    List<Kind> selectAllKind();

}

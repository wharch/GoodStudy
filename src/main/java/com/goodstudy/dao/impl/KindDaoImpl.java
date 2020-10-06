package com.goodstudy.dao.impl;

import com.goodstudy.dao.KindDao;
import com.goodstudy.domain.Kind;
import com.goodstudy.util.DBUtil;
import com.goodstudy.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
* 孙向锋
* kindDao实现类
* */
public class KindDaoImpl implements KindDao {
    /**
     * 添加类别
     * @param kind 类别对象
     * @return 布尔
     */
    @Override
    public boolean insert(Kind kind) {
        int i = DBUtil.doUpdate("insert into kind(kind_id,kind_name)values(?,?)",
                kind.getKindId(), kind.getKindName());
        return i > 0 ? true : false;
    }
    /**
     * 删除类别
     * @param kindName 类别名称
     * @return 布尔
     */
    @Override
    public boolean delete(String kindName) {
        int i = DBUtil.doUpdate("delete from kind where kind_name=?", kindName);
        return i > 0 ? true : false;
    }

    /**
     * 修改类别
     * @param kind 类别对象
     * @return 布尔
     */
    @Override
    public boolean update(Kind kind) {
        int i = DBUtil.doUpdate("update kind set kind_id=?,kind_name=?",
                kind.getKindId(), kind.getKindName());
        return i > 0 ? true : false;
    }

    /**
     * 分页查看类别信息
     * @param currentPage 页数 当前页
     * @param pageSize 每页显示几个
     * @return Page<Kind> 对象
     */
    @Override
    public Page<Kind> selectAll(int currentPage, int pageSize) {
        String sql = "select * from kind";
        Page page = DBUtil.doQueryByPage(sql, currentPage, pageSize);
        ResultSet rs = page.getRs();
        List<Kind> kinds = new ArrayList<Kind>();
        try {
            while (rs.next()) {
                kinds.add(new Kind(
                        rs.getInt("kind_id"),
                        rs.getString("kind_name")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        page.setData(kinds);
        return page;
    }

    /**
     * 根据类别名称查询
     * @param kindName 类别名称
     * @return Kind 对象
     */
    @Override
    public Kind selectByName(String kindName) {
        ResultSet rs = DBUtil.doQuery("select * from kind where kind_name=?",kindName);
        try {
            if (rs.next()) {
                return new Kind(rs.getInt("kind_id"),
                        rs.getString("kind_name"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return null;
    }
}

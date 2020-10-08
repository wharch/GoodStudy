package com.goodstudy.dao.impl;

import com.goodstudy.dao.SectionDao;
import com.goodstudy.domain.Course;
import com.goodstudy.domain.Section;
import com.goodstudy.util.DBUtil;
import com.goodstudy.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者:wh
 * 章节Section的dao实现
 */
public class SectionDaoImpl implements SectionDao {
    /**
     * 根据班级编号进行查询所有章节
     *
     * @param cId 班级编号
     * @return List<Section> 集合
     */
    @Override
    public List<Section> findAllSection(int cId) {
        String sql = "select * from section where c_id=?";
        ResultSet rs = DBUtil.doQuery(sql, cId);
        List<Section> sections = new ArrayList<>();
        try {
            while (rs.next()) {
                int sectionId = rs.getInt("section_id");
                String sectionName = rs.getString("section_name");
                Course course = new Course(cId, null, null, null, null, null, 0, 0);
                Section section = new Section(sectionId, sectionName, course);
                sections.add(section);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sections;
    }

    /**
     * 分页 根据课程编号进行查看所有章节
     *
     * @param currentPage 当前页
     * @param pageSize    一页显示多少记录
     * @return Page<Section> 对象
     */
    @Override
    public Page<Section> findAllSectionByPage(int currentPage, int pageSize, int cId) {
        String sql = "select * from section where c_id=?";
        Page<Section> page = DBUtil.doQueryByPage(sql, currentPage, pageSize, cId);
        ResultSet rs = page.getRs();
        List<Section> sections = new ArrayList<>();
        try {
            while (rs.next()) {
                int sectionId = rs.getInt("section_id");
                String sectionName = rs.getString("section_name");
                Course course = new Course(cId, null, null, null, null, null, 0, 0);
                Section section = new Section(sectionId, sectionName, course);
                sections.add(section);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        page.setData(sections);
        return page;
    }

    /**
     * 根据章节名称查看是否有此章节
     * @param sectionName 章节名称
     * @return Section 对象
     */
    @Override
    public Section findSectionByName(String sectionName) {
        String sql = "select * from section where section_name=?";
        ResultSet rs = DBUtil.doQuery(sql, sectionName);
        Section section = null;
        try {
            if (rs.next()) {
                int sectionId = rs.getInt("section_id");
                int cId = rs.getInt("c_id");
                Course course = new Course(cId, null, null, null, null, null, 0, 0);
                section = new Section(sectionId, sectionName, course);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return section;
    }

    /**
     * 添加章节
     *
     * @param section 章节对象
     * @return 布尔
     */
    @Override
    public boolean addSection(Section section) {
        String sql = "insert into section values(null,?,?)";
        return DBUtil.doUpdate(sql, section.getSectionName(), section.getCourse().getcId()) > 0;
    }

    /**
     * 根据章节编号进行更改章节名称
     *
     * @param section 章节名称
     * @return 布尔
     */
    @Override
    public boolean updateSection(Section section) {
        String sql = "update section set section_name=? where section_id=?";
        return DBUtil.doUpdate(sql, section.getSectionName(), section.getSectionId()) > 0;
    }

    /**
     * 根据章节编号进行删除章节
     * 并将章节内的视频删除
     *
     * @param sectionId 要删除的章节编号
     * @return 布尔
     */
    @Override
    public boolean delSection(int sectionId) {
        boolean flag = false;
        String sql = "delete from section where section_id=?";
        if (DBUtil.doUpdate(sql, sectionId) > 0) {
            String sql1 = "delete from course_info where section_id=?";
            flag = true;
        }
        return flag;
    }
}

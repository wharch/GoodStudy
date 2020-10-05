package com.goodstudy.dao;

import com.goodstudy.domain.Section;
import com.goodstudy.util.Page;

import java.util.List;

/**
 * 作者:wh
 * 章节Section的dao
 */
public interface SectionDao {
    //根据课程编号查看所有章节
    List<Section> findAllSection(int cId);

    //分页 根据课程编号查看所有章节
    Page<Section> findAllSectionByPage(int currentPage, int pageSize, int cId);

    //根据章节名查看该章节是否存在
    Section findSectionByName(String SectionName);

    //添加章节
    boolean addSection(Section section);

    //修改章节
    boolean updateSection(Section section);

    //删除章节
    boolean delSection(int sectionId);
}

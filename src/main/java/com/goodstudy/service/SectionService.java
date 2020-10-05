package com.goodstudy.service;

import com.goodstudy.domain.Section;
import com.goodstudy.util.Page;

import java.util.List;

/**
 *作者:wh
 * 章节service接口
 */
public interface SectionService {
    //根据课程编号查看所有章节
    List<Section> findAllSection(int cId);

    //分页 根据课程编号查看所有章节
    Page<Section> findAllSectionByPage(int currentPage, int pageSize, int cId);

    //添加章节
    boolean addSection(Section section);

    //修改章节
    boolean updateSection(Section section);

    //删除章节
    boolean delSection(int sectionId);
}

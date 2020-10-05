package com.goodstudy.service.impl;

import com.goodstudy.dao.SectionDao;
import com.goodstudy.dao.impl.SectionDaoImpl;
import com.goodstudy.domain.Section;
import com.goodstudy.service.SectionService;
import com.goodstudy.util.Page;

import java.util.List;

/**
 * 作者:wh
 * 章节service实现
 */
public class SectionServiceImpl implements SectionService {
    private SectionDao dao = new SectionDaoImpl();

    /**
     * 根据课程编号查询所有章节
     *
     * @param cId 课程编号
     * @return List<Section> 集合
     */
    @Override
    public List<Section> findAllSection(int cId) {
        return dao.findAllSection(cId);
    }

    /**
     * 分页 根据课程编号查看章节
     *
     * @param currentPage 当前页
     * @param pageSize    一页显示多少记录
     * @param cId         课程编号
     * @return Page<Section> 对象
     */
    @Override
    public Page<Section> findAllSectionByPage(int currentPage, int pageSize, int cId) {
        return dao.findAllSectionByPage(currentPage, pageSize, cId);
    }

    /**
     * 添加章节
     *
     * @param section 对象
     * @return 布尔
     */
    @Override
    public boolean addSection(Section section) {
        boolean flag = false;
        if (dao.findSectionByName(section.getSectionName()) == null) {
            if (dao.addSection(section)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 根据章节编号修改章节名称
     *
     * @param section 对象
     * @return 布尔
     */
    @Override
    public boolean updateSection(Section section) {
        return dao.updateSection(section);
    }

    /**
     * 根据章节编号删除章节
     * 并将章节内的视频删除
     *
     * @param sectionId 章节编号
     * @return 布尔
     */
    @Override
    public boolean delSection(int sectionId) {
        return dao.delSection(sectionId);
    }
}

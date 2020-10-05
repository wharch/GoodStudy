package com.goodstudy.dao;

import com.goodstudy.domain.Collection;
import com.goodstudy.util.Page;

import java.util.List;

/**
 * 收藏collection实体类的dao层
 * @author 刘美琦
 */
public interface CollectionDao {
    /**
     * 新增一条收藏记录
     * @param collection
     * @return
     */
    boolean insertCollection(Collection collection);

    /**
     * 根据收藏编号删除收藏记录
     * @param collectionId
     * @return
     */
    boolean deleteCollectionById(int collectionId);

    /**
     * 根据学生编号不分页查询收藏激励
     * @param stuId
     * @return
     */
    List<Collection> findAllCollectionByStuId(int stuId);

    /**
     *
     * @param stuId
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<Collection> findAllCollectionByStuIdByPage(int stuId,int currentPage,int pageSize);

    /**
     * 根据课程编号和学生编号查找收藏记录
     * @param cId
     * @param stuId
     * @return
     */
    Collection findCollectionByCIdAndStuId(int cId,int stuId);
}

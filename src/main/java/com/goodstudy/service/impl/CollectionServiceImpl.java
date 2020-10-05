package com.goodstudy.service.impl;

import com.goodstudy.dao.CollectionDao;
import com.goodstudy.dao.impl.CollectionDaoImpl;
import com.goodstudy.domain.Collection;
import com.goodstudy.service.CollectionService;
import com.goodstudy.util.Page;

import java.util.List;

/**
 * 收藏Collection实体类的Service层接口的实现类
 */
public class CollectionServiceImpl implements CollectionService {
    private CollectionDao collectionDao = new CollectionDaoImpl();
    /**
     * 新增一条收藏记录,先判断是否被收藏，同一个学生无法多次收藏同一个课程
     * @param collection
     * @return
     */
    @Override
    public boolean insertCollection(Collection collection) {
        Collection collectionByCIdAndStuId = collectionDao.findCollectionByCIdAndStuId(collection.getCourse().getcId(), collection.getStudent().getStuId());
        if(collectionByCIdAndStuId == null){
            return collectionDao.insertCollection(collection);
        }
        return false;
    }

    /**
     * 根据收藏编号删除一条收藏记录
     * @param collectionId
     * @return
     */
    @Override
    public boolean deleteCollectionById(int collectionId) {
        return collectionDao.deleteCollectionById(collectionId);
    }

    /**
     * 根据学生编号不分页查询该学生的相关收藏记录
     * @param stuId
     * @return
     */
    @Override
    public List<Collection> findAllCollectionByStuId(int stuId) {
        return collectionDao.findAllCollectionByStuId(stuId);
    }

    /**
     * 根据学生编号分页查询该学生相关的收藏记录
     * @param stuId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page<Collection> findAllCollectionByStuIdByPage(int stuId, int currentPage, int pageSize) {
        return collectionDao.findAllCollectionByStuIdByPage(stuId,currentPage,pageSize);
    }

    /**
     * 查询该学生对该课程的收藏状态
     * 当返回值为空则未收藏
     * 当有返回值对象则已经收藏过了，不可重复收藏
     * @param cId
     * @param stuId
     * @return
     */
    @Override
    public Collection findCollectionByCIdAndStuId(int cId, int stuId) {
        return collectionDao.findCollectionByCIdAndStuId(cId, stuId);
    }
}

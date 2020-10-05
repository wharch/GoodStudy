package com.goodstudy.dao.impl;

import com.goodstudy.dao.CollectionDao;
import com.goodstudy.domain.*;
import com.goodstudy.util.DBUtil;
import com.goodstudy.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 收藏collectionDao的实现
 * @author 刘美琦
 */
public class CollectionDaoImpl implements CollectionDao {
    /**
     * 新增一条收藏记录
     * @param collection
     * @return
     */
    @Override
    public boolean insertCollection(Collection collection) {
        String sql = "insert into collection values(null,?,?)";
        int i = DBUtil.doUpdate(sql, collection.getCourse().getcId(), collection.getStudent().getStuId());
        return i>0?true:false;
    }

    /**
     * 删除一条收藏记录
     * @param collectionId
     * @return
     */
    @Override
    public boolean deleteCollectionById(int collectionId) {
        String sql = "delete from collection where collection_id = ?";
        int i = DBUtil.doUpdate(sql, collectionId);
        return i>0?true:false;
    }

    /**
     * 根据学生编号查询该学生的相关收藏记录
     * @param stuId
     * @return
     */
    @Override
    public List<Collection> findAllCollectionByStuId(int stuId) {
        String sql = "select * from collection where stu_id = ?";
        String sqlCourse = "select * from course where c_id = ?";
        ResultSet rs = DBUtil.doQuery(sql, stuId);
        List<Collection> collections = new ArrayList<>();
        try {
            while (rs.next()){
                int collectionId = rs.getInt("collection_id");
                int cId = rs.getInt("c_id");
                ResultSet rsCourse = DBUtil.doQuery(sqlCourse, cId);
                Course course = null;
                if(rsCourse.next()){
                    String cName = rsCourse.getString("c_name");
                    int kindId = rsCourse.getInt("kind_id");
                    int tId = rsCourse.getInt("t_id");
                    String cMaster = rsCourse.getString("c_master");
                    String cInfo = rsCourse.getString("c_info");
                    double cPrice = rsCourse.getDouble("c_price");
                    int cStatus = rsCourse.getInt("c_status");
                    course = new Course(cId,cName,new Kind(kindId,null),new Teacher(tId),cMaster,cInfo,cPrice,cStatus);

                }
                Collection collection = new Collection(collectionId,course,new Student(stuId,null,null,null,null,null,null,null));
                collections.add(collection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collections;
    }

    /**
     * 根据学生编号分页查询收藏记录
     * @param stuId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page<Collection> findAllCollectionByStuIdByPage(int stuId, int currentPage, int pageSize) {
        String sql = "select * from collection where stu_id = ?";
        String sqlCourse = "select * from course where c_id = ?";
        Page page = DBUtil.doQueryByPage(sql, currentPage, pageSize, stuId);
        ResultSet rs = page.getRs();
        List<Collection> collections = new ArrayList<>();
        try {
            while (rs.next()){
                int collectionId = rs.getInt("collection_id");
                int cId = rs.getInt("c_id");
                ResultSet rsCourse = DBUtil.doQuery(sqlCourse, cId);
                Course course = null;
                if(rsCourse.next()){
                    String cName = rsCourse.getString("c_name");
                    int kindId = rsCourse.getInt("kind_id");
                    int tId = rsCourse.getInt("t_id");
                    String cMaster = rsCourse.getString("c_master");
                    String cInfo = rsCourse.getString("c_info");
                    double cPrice = rsCourse.getDouble("c_price");
                    int cStatus = rsCourse.getInt("c_status");
                    course = new Course(cId,cName,new Kind(kindId,null),new Teacher(tId),cMaster,cInfo,cPrice,cStatus);

                }
                Collection collection = new Collection(collectionId,course,new Student(stuId,null,null,null,null,null,null,null));
                collections.add(collection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        page.setData(collections);
        return page;
    }

    /**
     * 根据课程编号和学生编号查询收藏记录
     * @param cId
     * @param stuId
     * @return
     */
    @Override
    public Collection findCollectionByCIdAndStuId(int cId, int stuId) {
        String sql = "select * from collection where c_id = ? and stu_id = ?";
        ResultSet rs = DBUtil.doQuery(sql, cId, stuId);
        Collection collection = null;
        try {
            if(rs.next()){
                int collectionId = rs.getInt("collection_id");
                collection = new Collection(collectionId,new Course(cId,null,null,null,null,null,0,1),null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collection;
    }
}

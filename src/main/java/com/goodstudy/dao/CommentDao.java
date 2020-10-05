package com.goodstudy.dao;

import com.goodstudy.domain.Comment;
import com.goodstudy.util.Page;

import java.util.List;

/**
 * 评论comment实体类的dao层
 * @author 刘美琦
 */
public interface CommentDao {
    /**
     * 新增一条评论
     * @param comment
     * @return
     */
     boolean insertComment(Comment comment);

    /**
     * 根据评论编号删除评论
     * @param commentId
     * @return
     */
     boolean deleteCommentById(int commentId);

    /**
     * 不分页根据课程编号查看所有评论
     * @param cId
     * @return
     */
     List<Comment> findAllComment(int cId);

    /**
     * 分页根据课程编号查询所有评论
     * @param cId
     * @param currentPage
     * @param pageSize
     * @return
     */
     Page<Comment> findAllCommentByPage(int cId,int currentPage,int pageSize);

    /**
     * 根据学生编号查看自己的评论列表
     * @param stuId
     * @return
     */
     List<Comment> findCommentBySId(int stuId);

    /**
     * 根据学生编号分页查询自己的评论列表
     * @param stuId
     * @param currentPage
     * @param pageSize
     * @return
     */
     Page<Comment> findCommentBySIdByPage(int stuId,int currentPage,int pageSize);
}

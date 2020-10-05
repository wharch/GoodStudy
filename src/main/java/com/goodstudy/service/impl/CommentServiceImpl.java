package com.goodstudy.service.impl;

import com.goodstudy.dao.CommentDao;
import com.goodstudy.dao.impl.CommentDaoImpl;
import com.goodstudy.domain.Comment;
import com.goodstudy.service.CommentService;
import com.goodstudy.util.Page;
import java.util.List;

/**
 * 评论Comment实体类的Service层的实现
 * @author 刘美琦
 */
public class CommentServiceImpl implements CommentService {
    private CommentDao commentDao = new CommentDaoImpl();
    /**
     * 新增一条评论
     * 在订单处可以点击进行评价，从而不会出现未购买的学生对该课程评价的情况
     * @param comment
     * @return
     */
    @Override
    public boolean insertComment(Comment comment) {
        return commentDao.insertComment(comment);
    }

    /**
     * 根据评论id删除评论
     * @param commentId
     * @return
     */
    @Override
    public boolean deleteCommentById(int commentId) {
        return commentDao.deleteCommentById(commentId);
    }

    /**
     * 根据课程编号不分页查询评论列表
     * @param cId
     * @return
     */
    @Override
    public List<Comment> findAllComment(int cId) {
        return commentDao.findAllComment(cId);
    }

    /**
     * 根据课程编号分页查询评论列表
     * @param cId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page<Comment> findAllCommentByPage(int cId, int currentPage, int pageSize) {
        return commentDao.findAllCommentByPage(cId,currentPage,pageSize);
    }

    /**
     * 根据学生编号不分页查询评论列表
     * @param stuId
     * @return
     */
    @Override
    public List<Comment> findCommentBySId(int stuId) {
        return commentDao.findCommentBySId(stuId);
    }

    /**
     * 根据学生编号分页查询评论列表
     * @param stuId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page<Comment> findCommentBySIdByPage(int stuId, int currentPage, int pageSize) {
        return commentDao.findCommentBySIdByPage(stuId,currentPage,pageSize);
    }
}

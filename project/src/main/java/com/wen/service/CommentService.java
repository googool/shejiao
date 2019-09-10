package com.wen.service;

import com.wen.dao.CommentDAO;
import com.wen.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;


import java.util.List;

/**
 * @Author:HowieLee
 * @Date:1/9/2019
 * @Description:com.howie.wen.service
 * @version:1.0
 */
@Service
public class CommentService {

    @Autowired(required=false)
    @Qualifier("commentDAO")
    CommentDAO commentDAO;

    @Autowired(required=false)
    @Qualifier("sensitiveService")
    SensitiveService sensitiveService;


    public List<Comment> getCommentsByEntity(int entityId, int entityType) {
        return commentDAO.selectCommentByEntity(entityId, entityType);
    }

    public int addComment(Comment comment) {
        comment.setContent(HtmlUtils.htmlEscape(comment.getContent()));
        comment.setContent(sensitiveService.filter(comment.getContent()));
        return commentDAO.addComment(comment) > 0 ? comment.getId() : 0;
    }

    public int getCommentCount(int entityId, int entityType) {
        return commentDAO.getCommentCount(entityId, entityType);
    }

    public int getUserCommentCount(int userId) {
        return commentDAO.getUserCommentCount(userId);
    }

    public boolean deleteComment(int commentId) {
        return commentDAO.updateStatus(commentId, 1) > 0;
    }

    public Comment getCommentById(int id) {
        return commentDAO.getCommentById(id);
    }
}
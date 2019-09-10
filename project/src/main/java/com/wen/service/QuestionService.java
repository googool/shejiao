package com.wen.service;

import com.wen.dao.QuestionDAO;
import com.wen.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

/**
 * @Author:HowieLee
 * @Date:1/7/2019
 * @Description:com.howie.wen.service
 * @version:1.0
 */
@Service
public class QuestionService {

    @Autowired(required=false)
    @Qualifier("questionDAO")
    QuestionDAO questionDAO;

    @Autowired(required=false)
    @Qualifier("sensitiveService")
    SensitiveService sensitiveService;

    public Question getById(int id) {
        return questionDAO.getById(id);
    }

    public int addQuestion(Question question) {
        question.setTitle(HtmlUtils.htmlEscape(question.getTitle()));
        question.setContent(HtmlUtils.htmlEscape(question.getContent()));
        // 敏感词过滤
        question.setTitle(sensitiveService.filter(question.getTitle()));
        question.setContent(sensitiveService.filter(question.getContent()));
        return questionDAO.addQuestion(question) > 0 ? question.getId() : 0;
    }

    public List<Question> getLatestQuestions(int userId, int offset, int limit) {
        return questionDAO.selectLatestQuestions(userId, offset, limit);
    }

    public List<Question> getsearchquestion(String userId, int offset, int limit) {
        return questionDAO.selectsearchquestion(userId, offset, limit);
    }

    public int updateCommentCount(int id, int count) {
        return questionDAO.updateCommentCount(id, count);
    }
}
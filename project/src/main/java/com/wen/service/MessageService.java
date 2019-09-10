package com.wen.service;

import com.wen.dao.MessageDAO;
import com.wen.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @Author:HowieLee
 * @Date:1/7/2019
 * @Description:com.howie.wen.controller
 * @version:1.0
 */

@Service
public class MessageService {
    @Autowired(required=false)
    @Qualifier("messageDAO")
    MessageDAO messageDAO;

    @Autowired(required=false)
    @Qualifier("sensitiveService")
    SensitiveService sensitiveService;

    public int addMessage(Message message) {
        message.setContent(sensitiveService.filter(message.getContent()));
        return messageDAO.addMessage(message);
    }

    public List<Message> getConversationDetail(String conversationId, int offset, int limit) {
        return messageDAO.getConversationDetail(conversationId, offset, limit);
    }

    public List<Message> getConversationList(int userId, int offset, int limit) {
        return messageDAO.getConversationList(userId, offset, limit);
    }

    public int getConvesationUnreadCount(int userId, String conversationId) {
        return messageDAO.getConvesationUnreadCount(userId, conversationId);
    }
    public int updateConvesationUnread(String conversationId, int hasRead) {
        return messageDAO.updateStatus(conversationId, hasRead);
    }

}

package com.wen.async.handler;

import com.wen.async.EventHandler;
import com.wen.async.EventModel;
import com.wen.async.EventType;
import com.wen.model.EntityType;
import com.wen.model.Message;
import com.wen.model.User;
import com.wen.service.MessageService;
import com.wen.service.UserService;
import com.wen.util.WendaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class FollowHandler implements EventHandler {
    //autowired为自动注入
    @Autowired(required=false)
    @Qualifier("messageService")
    MessageService messageService;

    @Autowired(required=false)
    @Qualifier("userService")
    UserService userService;
    /**
     * @Author HowieLee
     * @Description //TODO 这个为针对关注用户的handler
     * @Date 20:39 1/14/2019
     * @Param 
     * @return 
     **/
    
    @Override
    public void doHandle(EventModel model) {
        Message message = new Message();
        message.setFromId(WendaUtil.SYSTEM_USERID);
        message.setToId(model.getEntityOwnerId());
        message.setCreatedDate(new Date());
        User user = userService.getUser(model.getActorId());

        if (model.getEntityType() == EntityType.ENTITY_QUESTION) {
            message.setContent("用户" + user.getName()
                    + "关注了你的问题,http://127.0.0.1:8080/question/" + model.getEntityId());
        } else if (model.getEntityType() == EntityType.ENTITY_USER) {
            message.setContent("用户" + user.getName()
                    + "关注了你,http://127.0.0.1:8080/user/" + model.getActorId());
        }

        messageService.addMessage(message);
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.FOLLOW);
    }
}

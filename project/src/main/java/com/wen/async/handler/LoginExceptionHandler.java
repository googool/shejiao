package com.wen.async.handler;

import com.wen.async.EventHandler;
import com.wen.async.EventModel;
import com.wen.async.EventType;
import com.wen.util.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class LoginExceptionHandler implements EventHandler {

    @Autowired(required=false)
    @Qualifier("mailSender")
    MailSender mailSender;
    /**
     * @Author HowieLee
     * @Description //TODO 针对登录之后邮件提醒的handler
     * @Date 21:08 1/14/2019
     * @Param 
     * @return 
     **/
    
    @Override
    public void doHandle(EventModel model) {
        // xxxx判断发现这个用户登陆异常
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", model.getExt("username"));
        mailSender.sendWithHTMLTemplate(model.getExt("email"), "Login Reminder", "templates/mails/login_exception.html", map);
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.LOGIN);
    }
}

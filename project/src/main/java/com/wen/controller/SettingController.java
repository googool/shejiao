package com.wen.controller;

import com.wen.dao.QuestionDAO;
import com.wen.dao.UserDAO;
import com.wen.model.Question;
import com.wen.model.User;
import com.wen.service.WendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Random;

//import org.springframework.util.Assert;

@Controller
public class SettingController {
    @Autowired(required=false)
    @Qualifier("wendaService")
    WendaService wendaService;

    @RequestMapping(path = {"/setting"},method = {RequestMethod.GET})
    @ResponseBody
    public String index(HttpSession httpSession){
        return "Setting OK. " + wendaService.getMessage(1);
    }


    @Autowired(required=false)
    @Qualifier("userDAO")
    UserDAO userDAO;

    @Autowired(required=false)
    @Qualifier("questionDAO")
    QuestionDAO questionDAO;

//	@WebAppConfiguration
    @RequestMapping(path = {"/init"},method = {RequestMethod.GET})
    @ResponseBody
    public String initDatabase() {
        Random random = new Random();

        for(int i = 0 ; i < 15 ; i++){
            User user = new User();
            user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
            user.setName(String.format("USER%d", i));
            user.setPassword("xx");
            user.setSalt("xx");
            userDAO.addUser(user);

//            user.setPassword("xx");
//            userDAO.updatePassword(user);
            Question question = new Question();
            question.setCommentCount(i);
            Date date = new Date();
            date.setTime(date.getTime() + 1000 * 3600 * 5 * i);
            question.setCreatedDate(date);
            question.setUserId(i + 1);
            question.setTitle(String.format("TITLE{%d}", i));
            question.setContent(String.format("Balaababalalalal Content %d", i));
            questionDAO.addQuestion(question);

        }

//        Assert.assertEquals("xx", userDAO.selectById(1).getPassword());
//        userDAO.deleteById(1);
//        Assert.assertNull(userDAO.selectById(1));
        return "hello world";
    }

}

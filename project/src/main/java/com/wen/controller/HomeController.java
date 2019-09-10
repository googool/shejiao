package com.wen.controller;

import com.wen.model.*;
import com.wen.service.CommentService;
import com.wen.service.FollowService;
import com.wen.service.QuestionService;
import com.wen.service.UserService;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:HowieLee
 * @Date:1/7/2019
 * @Description:com.howie.wen.controller
 * @version:1.0
 */
@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired(required=false)
    @Qualifier("questionService")
    QuestionService questionService;

    @Autowired(required=false)
    @Qualifier("userService")
    UserService userService;

    @Autowired(required=false)
    @Qualifier("commentService")
    CommentService commentService;

    @Autowired(required=false)
    @Qualifier("followService")
    FollowService followService;

    @Autowired(required=false)
    @Qualifier("hostHolder")
    HostHolder hostHolder;

    private List<ViewObject> getQuestions(int userId, int offset, int limit) {
        List<Question> questionList = questionService.getLatestQuestions(userId, offset, limit);
        List<ViewObject> vos = new ArrayList<>();
        for (Question question : questionList) {
            ViewObject vo = new ViewObject();
            vo.set("question", question);
            vo.set("followCount", followService.getFollowerCount(EntityType.ENTITY_QUESTION, question.getId()));
            vo.set("user", userService.getUser(question.getUserId()));
            vos.add(vo);
        }
        return vos;
    }


    private List<ViewObject> getSearchQuestions(int Id, int offset, int limit) {
        List<Question> questionList = questionService.getLatestQuestions(Id, offset, limit);
        List<ViewObject> vos = new ArrayList<>();
        for (Question question : questionList) {
            ViewObject vo = new ViewObject();
            vo.set("question", question);
            vo.set("followCount", followService.getFollowerCount(EntityType.ENTITY_QUESTION, question.getId()));
            vo.set("user", userService.getUser(question.getUserId()));
            vos.add(vo);
        }
        return vos;
    }

    @RequestMapping(path = {"/", "/index"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model,
                        @RequestParam(value = "pop", defaultValue = "0") int pop) {
        model.addAttribute("vos", getQuestions(0, 0, 20));
        return "index";
    }


    @RequestMapping(path = {"/search"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String regloginPage(Model model, @RequestParam(value = "q", required = false) String q) {
        List<Question> question = questionService.getsearchquestion(q,0,15);
        List<ViewObject> questionss = new ArrayList<>();
        for (Question questio : question) {
            ViewObject vo = new ViewObject();
            vo.set("question", questio);
            vo.set("followCount", followService.getFollowerCount(EntityType.ENTITY_QUESTION, questio.getId()));
            //System.out.println(questio.getId());
            vo.set("user", userService.getUser(questio.getUserId()));
            questionss.add(vo);
        }
        model.addAttribute("questionss",questionss);
        return "SearchPage";
    }



    @RequestMapping(path = {"/user/{userId}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String userIndex(Model model, @PathVariable("userId") int userId) {
        model.addAttribute("vos", getQuestions(userId, 0, 10));

        User user = userService.getUser(userId);
        ViewObject vo = new ViewObject();
        vo.set("user", user);
        vo.set("commentCount", commentService.getUserCommentCount(userId));
        vo.set("followerCount", followService.getFollowerCount(EntityType.ENTITY_USER, userId));
        vo.set("followeeCount", followService.getFolloweeCount(userId, EntityType.ENTITY_USER));
        if (hostHolder.getUser() != null) {
            vo.set("followed", followService.isFollower(hostHolder.getUser().getId(), EntityType.ENTITY_USER, userId));
        } else {
            vo.set("followed", false);
        }
        model.addAttribute("profileUser", vo);
        return "profile";
    }
}
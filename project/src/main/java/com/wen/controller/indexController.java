package com.wen.controller;

import com.wen.model.User;
import com.wen.service.WendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Author:HowieLee
 * @Date:1/5/2019
 * @Description:com.howie.wenda.controller
 * @version:1.0
 */

/**
 * @Author HowieLee
 * @Description 首页的入口层（Controller）
 * @Date 10:43 1/5/2019
 * @Param ：String类型的数据
 * @return：直接返回一个字符串而不是模版
 **/

//@Controller
public class indexController {
    @Autowired
    WendaService wendaService;
//
//    @RequestMapping(path = {"/","/index"},method = {RequestMethod.GET})
//    @ResponseBody
//    public String index(HttpSession httpSession){
//        return wendaService.getMessage(2) + "Hello Howie " + httpSession.getAttribute("msg");
//    }
    /**
     * @Author HowieLee
     * @Description //设置一个profile页，将userId可以解析出来,后面为请求参数的形式来传递
     * @Date 11:09 1/5/2019
     * @Param
     * @return
     **/



    @RequestMapping(path = {"/profile/{groupId}/{userId}"})
    @ResponseBody
    public String profile(@PathVariable("userId") int userId,
                          @PathVariable("groupId") String groupId,
                          @RequestParam(value = "type",defaultValue = "type") int type,
                          @RequestParam(value = "key",defaultValue = "value",required = false) String key){
        return String.format("Profile Page of %s/%d, type:%d key:%s",groupId,userId,type,key);
    }


    @RequestMapping(path = {"/vm"})
    public String template(Model model){
        model.addAttribute("value1","vvvv1");
        List<String> colors = Arrays.asList(new String[]{"RED","GREEN","BLUE"});
        model.addAttribute("colors",colors);

        Map<String,String> map = new HashMap<>();
        for(int i = 0 ; i < 4 ; i++){
            map.put(String.valueOf(i),String.valueOf(i * i));
        }
        model.addAttribute("map",map);
        model.addAttribute("user",new User("LEE"));
        return "home";
    }
    /**
     * @Author HowieLee
     * @Description //有关session和request
     * @Date 20:13 1/5/2019
     * @Param
     * @return
     **/

    @RequestMapping(path = {"/request"})
    @ResponseBody
    public String template(Model model, HttpServletResponse response,
                           HttpServletRequest request,
                           HttpSession httpSession,
                           @CookieValue("JSESSIONID") String sessionId) {
        StringBuilder sc = new StringBuilder();
        sc.append("COOKIEVALUE" + sessionId);
        Enumeration<String> headerNmaes = request.getHeaderNames();
        while(headerNmaes.hasMoreElements()){
            String name = headerNmaes.nextElement();
            sc.append(name + ":" + request.getHeader(name) + "<br>");
        }
        if(request.getCookies() != null){
            for(Cookie cookie : request.getCookies()){
                sc.append("Cookie" + cookie.getName() + "value" + cookie.getValue());
            }
        }
        sc.append(request.getMethod() + "<br>");
        sc.append(request.getQueryString() + "<br>");
        sc.append(request.getPathInfo() + "<br>");
        sc.append(request.getRequestURI() + "<br>");

        response.addHeader("howieId","hello");
        response.addCookie(new Cookie("username","howie"));
        return sc.toString();
    }

    /**
     * @Author HowieLee
     * @Description //演示301和302的模式
     * @Date 20:13 1/5/2019
     * @Param
     * @return
     **/

    @RequestMapping(path = {"/redirect/{code}"})
    public RedirectView Redirect(@PathVariable("code") int code,
                                 HttpSession httpSession){
        httpSession.setAttribute("msg"," jump from redirect");
        RedirectView red = new RedirectView("/",true);
        if(code == 301)
            red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
        return red;
    }

    @RequestMapping(path = {"/admin"})
    @ResponseBody
    public String admin(@RequestParam("key") String key) throws IllegalAccessException {
        if("admin".equals(key)){
            return "hello admin";
        }
        throw new IllegalAccessException("参数不对");
    }

    /**
     * @Author HowieLee
     * @Description //专门处理异常的函数
     * @Date 20:09 1/5/2019
     * @Param
     * @return
     **/

    @ExceptionHandler()
    @ResponseBody
    public String error(Exception e){
        return "error" + e.getMessage();
    }

}

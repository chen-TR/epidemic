package com.ctr.epidemic.controller;


import com.ctr.epidemic.model.UserInfo;
import com.ctr.epidemic.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/2/26 10:27
 */
@Controller
@RequestMapping("/user")
public class UserController {

    public static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(UserInfo userInfo, Model model, HttpSession session){

        logger.debug("login() function running...");
        logger.debug(userInfo.getAccount()+", "+userInfo.getPassword());

        UserInfo user = userService.findByAccount(userInfo.getAccount());
        if(user==null){
            //查无此人
            model.addAttribute("msg","查无此人");
            return "login";
        }else if(user.getPassword().equals(userInfo.getPassword())){
            //登陆成功
            session.setAttribute("loginedUser",user);
            return "redirect:/main.jsp";
        }
        //密码错误，登陆失败返回登录页
        model.addAttribute("msg","密码错误");
        return "login";
    }

}

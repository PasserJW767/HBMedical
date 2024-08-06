package com.lanqiao.zzy.controller;

import com.lanqiao.zzy.domain.User;
import com.lanqiao.zzy.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"logUser"})
@Slf4j
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login")  //默认返回页面或重定向 （redict）
    public String login(User user, Model model){
        log.info(user.toString());

        final User logUser = this.userService.selectForLogin(user);
        if (logUser != null){
            model.addAttribute("logUser",logUser);

            return "redirect:/";

        }else{
            return "login";
        }
    }

    @ResponseBody  //返回json数据
    @RequestMapping("/isLogin")
    public String islogin(User user, Model model){
        User logUser = this.userService.selectForLogin(user);

        if (logUser != null){//用户名密码正确，返回信息给前端

            return "{\"status\": \"success\", \"msg\": \"密码正确~~\"}";

        }else{
            return "{\"status\": \"fail\", \"msg\": \"密码错误，请重新输入！！！\"}";
        }
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}

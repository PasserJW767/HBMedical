package com.lanqiao.zzy.controller;

import com.lanqiao.zzy.domain.User;
import com.lanqiao.zzy.service.IMailVerifyService;
import com.lanqiao.zzy.service.IOrganizationService;
import com.lanqiao.zzy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class RegisterController {

    @Autowired
    IMailVerifyService mailVerifyService;

    @Autowired
    IOrganizationService organizationService;

    @Autowired
    IUserService userService;

    @RequestMapping("/registerPage")
    public String registerPage(){
        return "register";
    }

    @RequestMapping("/test")
    public String jump(){
        return "test";
    }

    @RequestMapping(value = "/register")
    public String register(User user, HttpServletRequest request){
//        产生唯一标识，设置标识
        String itemcode = UUID.randomUUID().toString();
        user.setItemcode(itemcode);
        user.setUsername(user.getName());
        user.setCreater("System");
        user.setUpdater("System");
//        插入用户
        int i = userService.insertSelective(user);
        if(i >= 1){
            return "/";
        } else {
            return "register";
        }
    }

    @RequestMapping("/register/getOrgInfo")
    @ResponseBody
    public List registerGetOrgInfo(){
        return this.organizationService.selectAll();
    }

    @RequestMapping(value = "/register/verify",produces= "application/json;charset=utf-8")
    @ResponseBody
    public String registerVerify(HttpServletRequest request,HttpSession session) {
//        获得邮箱
        String email = request.getParameter("email");
//        发送验证码
        boolean flag = mailVerifyService.sendVerifyCode(email);
        String verifyCode = mailVerifyService.getVerifyCode();
//        如果发送失败，返回NULL
        if(!flag){
            return null;
        } else {
//        发送成功
//        将接收人及其验证码存入Hashmap中
            Map<String,String> map = (Map<String, String>) session.getAttribute("VerifyCodeMap");
//        若map不存在
            if(map == null){
                map = new HashMap<>();
                map.put(email,verifyCode);
            } else {
//            若map存在
                if(map.containsKey(email)){
//                存在这个邮箱的验证码
                    map.remove(email);  //移除原本的键值对
                    map.put(email,verifyCode);  //插入新的键值对
                } else {
//                map不存在
                    map = new HashMap<>();
                    map.put(email,verifyCode);
                }
            }
            session.setAttribute("VerifyCodeMap",map);
            return "success";
        }
    }

    @RequestMapping(value = "/register/verifyCode",produces= "application/json;charset=utf-8")
    @ResponseBody
    public String registerVerifyCode(HttpServletRequest request,HttpSession session){
//        获得用户的邮箱
        String email = request.getParameter("email");
//        获得用户输入的验证码
        String verifyCode = request.getParameter("verifyCode");
//        从session中拿取用户的验证码
        Map<String,String> verifyCodeMap = (Map<String, String>) session.getAttribute("VerifyCodeMap");
        String realCode = null;
        if(verifyCodeMap == null){
            return "fail";
        } else {
            realCode = verifyCodeMap.get(email);
            if(verifyCode.equals(realCode))
                return "success";
            else
                return "fail";
        }
    }

    @RequestMapping(value = "/register/verifyUserName",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String registerVerifyUserName(HttpServletRequest request,HttpSession session){
//        获得用户名
        String username = request.getParameter("username");
//        从库里查用户名是否重复
        User checkUser = this.userService.selectByUsername(username);
//        判断
        if(checkUser == null){
            return "success";
        } else {
            return "false";
        }
    }



}

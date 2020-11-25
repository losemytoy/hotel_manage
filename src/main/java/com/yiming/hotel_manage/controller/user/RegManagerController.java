package com.yiming.hotel_manage.controller.user;

import com.yiming.hotel_manage.pojo.User;
import com.yiming.hotel_manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegManagerController {
    @Autowired
    private UserService userService;


    @PostMapping("/doReg")
    public String doReg(String userAccount,String userPwd,String userSfz,String userName,String userTel, Model model) throws Exception {
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPwd(userPwd);
        user.setUserSfz(userSfz);
        user.setUserName(userName);
        user.setUserTel(userTel);
        if(userAccount==null||userAccount==""||userAccount=="null"){
            model.addAttribute("error","请输入账号！");
            return "login/register";
        }
        if (userService.selectUser(userAccount)!= null) {
            model.addAttribute("error", "该账号已经存在");
            return "login/register";
        }
        if(user.getUserPwd()==null||user.getUserPwd()==""||user.getUserPwd()=="null"){
            model.addAttribute("error","请输入密码！");
            return "login/register";
        }
        if(user.getUserSfz()==null||user.getUserSfz()==""||user.getUserSfz()=="null"){
            model.addAttribute("error","请输入身份证！");
            return "login/register";
        }
        if(user.getUserName()==null||user.getUserName()==""||user.getUserName()=="null"){
            model.addAttribute("error","请输入姓名！");
            return "login/register";
        }
        if(user.getUserTel()==null||user.getUserTel()==""||user.getUserTel()=="null"){
            model.addAttribute("error","请输入联系方式！");
            return "login/register";
        }
        userService.addUser(user);
        return "/login/user_login";
    }
}

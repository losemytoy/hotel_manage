package com.yiming.hotel_manage.controller;

import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.pojo.User;
import com.yiming.hotel_manage.service.LogService;
import com.yiming.hotel_manage.shiro.LocalUsernamePasswordToken;
import io.netty.util.internal.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private LogService logService;


    private static final transient Logger log = LoggerFactory.getLogger(LoginController.class);

    @PostMapping(value = "/admin_login")
    public String login(String adminAccount, String adminPwd, Model model) throws Exception {
        Subject currentAdmin = SecurityUtils.getSubject(); //获取当前登录用户的值
        if (!currentAdmin.isAuthenticated()) {
            Admin admin = (Admin) currentAdmin.getPrincipal();
            admin = logService.getAdminByAccount(adminAccount);
            Session session = currentAdmin.getSession();
            session.setAttribute("adminId", admin);
            session.setAttribute("adminAccount",adminAccount);
            LocalUsernamePasswordToken token = new LocalUsernamePasswordToken(adminAccount, adminPwd,"Admin");
            token.setRememberMe(true);
            try {
                currentAdmin.login(token);
                return "redirect:/admin/main";
//                if ("admin".equals(admin.getAdminType())) {
//                    return "redirect:/admin/main";
//                }
//                else if ("employee".equals(admin.getAdminType())){
//                    return "admin/empMain";
//                }
            } catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
                String msg = "用户不存在";
                model.addAttribute("msg", msg);
                return "login/admin_login";
            } catch (IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
                String msg = "密码不正确";
                model.addAttribute("msg", msg);
                return "login/admin_login";
            } catch (AuthenticationException ae) {
                //unexpected condition?  error?
                String msg = "未知错误";
                model.addAttribute("msg", msg);
                return "login/admin_login";
            }
        }
        return "login/admin_login";
    }

    @PostMapping(value = "/user_login")
    public String userlogin(String userAccount, String userPwd, Model model) throws Exception {
        Subject curretUser = SecurityUtils.getSubject(); //获取当前登录用户的值
        if (!curretUser.isAuthenticated()) {
            User user = (User) curretUser.getPrincipal();
            user = logService.getUserByAccount(userAccount);
            Session session = curretUser.getSession();
            session.setAttribute("userId", user);
            session.setAttribute("userAccount",userAccount);
            LocalUsernamePasswordToken token = new LocalUsernamePasswordToken(userAccount, userPwd,"User");
//            token.setRememberMe(true);
            try {
                curretUser.login(token);
                return "user/main";

            } catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
                String msg = "用户不存在,请先注册";
                model.addAttribute("msg", msg);
                return "login/register";
            } catch (IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
                String msg = "密码不正确";
                model.addAttribute("msg", msg);
                return "login/user_login";
            } catch (AuthenticationException ae) {
                //unexpected condition?  error?
                String msg = "未知错误";
                model.addAttribute("msg", msg);
                return "login/user_login";
            }
        }
        return "login/user_login";
    }


//    @PostMapping(value = "/user_login")
//    public String userlogin(@RequestParam("userAccount") String useraccount,
//                            @RequestParam("userPwd") String userpwd,
//                            Map<String,Object> map, HttpSession session){
//        if (logService.checkLogin(useraccount,userpwd)){
//            return "user/main";
//        }
//        else
//            map.put("msg","登陆失败");
//            return "login/user_login";
//    }

    @GetMapping("/user_register")
    public String toReg(){
        return "login/register";
    }

    @GetMapping("/loginOut")
    public String loginOut() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/user";
    }
}
package com.yiming.hotel_manage.controller;

import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.service.AdminLogService;
import org.apache.catalina.security.SecurityUtil;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private AdminLogService adminLogService;

    private static final transient Logger log = LoggerFactory.getLogger(LoginController.class);

    @PostMapping(value = "/admin_login")
    public String login(String adminAccount, String adminPwd, Model model) throws Exception {
        Subject currentAdmin = SecurityUtils.getSubject(); //获取当前登录用户的值
        if (!currentAdmin.isAuthenticated()) {
            Admin admin = (Admin) currentAdmin.getPrincipal();
            admin = adminLogService.getAdminByAccount(adminAccount);
            Session session = currentAdmin.getSession();
            session.setAttribute("adminId", admin);
            UsernamePasswordToken token = new UsernamePasswordToken(adminAccount, adminPwd);
            token.setRememberMe(true);
            try {
                currentAdmin.login(token);
                if ("admin".equals(admin.getAdminType())) {
                    return "admin/main";
                }
            } catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
                String msg = "用户不存在";
                model.addAttribute("msg", msg);
                return "admin";
            } catch (IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
                String msg = "密码不正确";
                model.addAttribute("msg", msg);
                return "admin";
            } catch (AuthenticationException ae) {
                //unexpected condition?  error?
                String msg = "未知错误";
                model.addAttribute("msg", msg);
                return "admin";
            }
        }
        return "admin";
    }
}
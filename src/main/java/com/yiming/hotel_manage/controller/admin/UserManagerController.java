package com.yiming.hotel_manage.controller.admin;

import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.pojo.User;
import com.yiming.hotel_manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserManagerController {
    @Autowired
    private UserService userService;

    //显示所有客户信息
    @GetMapping("/admin/users")
    public String getAllUser(Model model){
        List<User> users = userService.getAllUser();
        model.addAttribute("users",users);
        return "admin/user_Manage";
    }


    //来到修改页面，查出当前用户，在页面回显
    @GetMapping("/adminuser/{id}")
    public String getUserById(@PathVariable("id") String id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "admin/user_modify";
    }

    //修改用户
    @PutMapping("/adminuser/modify")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/admin/users";
    }

    //删除用户
    @DeleteMapping("/adminuser/{id}")
    public String deleteUser(@PathVariable("id") String id){
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

    //搜索用户
    @PostMapping("/admin/getUserInfo")
    public String getUserInfo(@RequestParam("username") String name,Model model){
        List<User> user = userService.getUserInfo(name);
        model.addAttribute("users",user);
        return "admin/user_Manage";
    }
}

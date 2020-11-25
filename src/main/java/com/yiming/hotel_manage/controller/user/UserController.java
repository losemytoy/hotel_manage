package com.yiming.hotel_manage.controller.user;

import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.pojo.Room;
import com.yiming.hotel_manage.pojo.User;
import com.yiming.hotel_manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/main")
    public String tomain(){
        return "user/main";
    }

    //显示当前用户信息
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") String id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "user/user_info";
    }

    //来到修改页面，查出当前用户，在页面回显
    @GetMapping("/usermodify/{id}")
    public String getUserByIdMOd(@PathVariable("id") String id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "user/user_modify";
    }

    //修改房间信息
    @PutMapping("/user/modify")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/user/main";
    }

}

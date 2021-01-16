package com.yiming.hotel_manage.controller.user;

import com.yiming.hotel_manage.pojo.Room;
import com.yiming.hotel_manage.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    //显示所有房间信息
    @GetMapping("/user/rooms")
    public String getAllRoom(Model model)throws Exception{
        List<Room> rooms = roomService.getAllRoom();
        model.addAttribute("rooms",rooms);
        return "user/user_reserve";
    }

    //预定房间
    //类加锁，使房间预定操作一次只能一个用户操作
    @RequestMapping("/userres/{id}/{account}")
    public synchronized String addRoom(@PathVariable("id") Integer id,
                          @PathVariable("account") String account){
        roomService.resRoom(id,account);
        return "redirect:/user/rooms";
    }
}

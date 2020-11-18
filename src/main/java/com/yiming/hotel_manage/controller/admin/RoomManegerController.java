package com.yiming.hotel_manage.controller.admin;


import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.pojo.Room;
import com.yiming.hotel_manage.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class RoomManegerController {

    @Autowired
    private RoomService roomService;

    //显示所有房间信息
    @GetMapping("/admin/rooms")
    public String getAllRoom(Model model)throws Exception{
        List<Room> rooms = roomService.getAllRoom();
        model.addAttribute("rooms",rooms);
        System.out.println(rooms);
        return "admin/room_Manage";
    }

    //来到修改页面，查出当前房间，在页面回显
    @GetMapping("/adminroom/{id}")
    public String getRoomById(@PathVariable("id") Integer id, Model model){
        Room room = roomService.getRoomById(id);
        model.addAttribute("room",room);
        return "admin/room_Modify";
    }

    //修改房间信息
    @PutMapping("/adminroom/modify")
    public String updateRoom(Room room){
        System.out.println(room);
        roomService.updateRoom(room);
        return "redirect:/admin/rooms";
    }

    //删除房间
    @DeleteMapping("/adminroomdel/{id}")
    public String deleteRoom(@PathVariable("id") Integer id){
        roomService.deleteRoom(id);
        return "redirect:/admin/rooms";
    }

    //导向添加房间页面
    @GetMapping("/admin/addroom")
    public String toRoom(){
        return "admin/room_Modify";
    }

    //添加房间
    @PostMapping("/adminroom/modify")
    public String addRoom(Room room){
        roomService.addRoom(room);
        return "redirect:/admin/rooms";
    }

    //查找房间
    @PostMapping("/admin/getRoomInfo")
    public String getRoomInfo(@RequestParam("roomId") Integer id,Model model){
        Room room = roomService.getRoomById(id);
        model.addAttribute("rooms",room);
        return "admin/room_Manage";
    }
}

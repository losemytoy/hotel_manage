package com.yiming.hotel_manage.controller.admin;

import com.yiming.hotel_manage.pojo.Admin;
import com.yiming.hotel_manage.service.AdminService;
import com.yiming.hotel_manage.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class EmpManageController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private RoomService roomService;

    @GetMapping("/admin/main")
    public String getNum(Model model, HttpServletRequest request, HttpServletResponse response)throws Exception{
        int empCount = adminService.getEmpCount("employee");
        int userCount = adminService.getUserCount();
        int roomCount = roomService.getRoomCount();
        int empRoomCount = roomService.getRoomCountByType("有");

        model.addAttribute("empCount",empCount);
        model.addAttribute("userCount",userCount);
        model.addAttribute("roomCount",roomCount);
        model.addAttribute("empRoomCount",empRoomCount);
        return "admin/main";
    }

    //显示所有员工信息
    @GetMapping("/admin/emps")
    public String getAllAdminer(Model model, HttpServletRequest request, HttpServletResponse response)throws Exception{
        List<Admin> admins = adminService.getAllAdminers();
        for (Admin admin:admins){
            if("admin".equals(admin.getAdminType())){
                admin.setAdminType("管理员");
            }else if("employee".equals(admin.getAdminType())){
                admin.setAdminType("员工");
            }
        }
        model.addAttribute("admins",admins);
        return "admin/emp_Manage";
    }

    //来到添加员工页面
    @GetMapping("/admin/add")
    public String toAdd(){
        return "admin/emp_modify";
    }

    //添加员工
    @PostMapping("/admin/modify")
    public String addAdmin(Admin admin){
        adminService.addAdmin(admin);
        return "redirect:/admin/emps";
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/admin/{id}")
    public String getAdminById(@PathVariable("id") Integer id,Model model){
        Admin admin = adminService.getAdminById(id);
        model.addAttribute("admin",admin);
        return "admin/emp_modify";
    }

    //修改员工
    @PutMapping("/admin/modify")
    public String updateAdmin(Admin admin){
        System.out.println(admin);
        adminService.updateAdmin(admin);
        return "redirect:/admin/emps";
    }

    //删除员工
    @DeleteMapping("/admin/{id}")
    public String deleteAdmin(@PathVariable("id") Integer id){
        adminService.deleteAdmin(id);
        return "redirect:/admin/emps";
    }

    //搜索员工
    @PostMapping("/admin/getEmpInfo")
    public String getEmpInfo(@RequestParam("name") String name,Model model){
        List<Admin> admin = adminService.getEmpInfo(name);
        model.addAttribute("admins",admin);
        return "admin/emp_Manage";
    }
}

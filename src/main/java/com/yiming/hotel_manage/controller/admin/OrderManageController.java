package com.yiming.hotel_manage.controller.admin;

import com.yiming.hotel_manage.pojo.CheckOrder;
import com.yiming.hotel_manage.pojo.ReserveOrder;
import com.yiming.hotel_manage.pojo.Room;
import com.yiming.hotel_manage.service.CheckService;
import com.yiming.hotel_manage.service.ReserveService;
import com.yiming.hotel_manage.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderManageController {
    @Autowired
    private CheckService checkService;

    @Autowired
    private ReserveService reserveService;

    //显示所有入住订单信息
    @GetMapping("/admin/checkorder")
    public String getAllCheckOrder(Model model)throws Exception{
        List<CheckOrder> checkOrders = checkService.getAllCheckOrder();
        model.addAttribute("checkorders",checkOrders);
        System.out.println(checkOrders);
        return "admin/order_check_Manage";
    }


    //删除入住订单
    @DeleteMapping("/admincheckdel/{id}")
    public String deleteCheckOrder(@PathVariable("id") Integer id){
        checkService.deleteCheckOrder(id);
        return "redirect:/admin/checkorder";
    }

    //显示所有预约订单信息
    @GetMapping("/admin/resorder")
    public String getAllResOrder(Model model)throws Exception{
        List<ReserveOrder> reserveOrders = reserveService.getAllResOrder();
        model.addAttribute("resorders",reserveOrders);
        return "admin/order_reserve_Manage";
    }


    //删除预约订单
    @DeleteMapping("/adminresdel/{id}")
    public String deleteResOrder(@PathVariable("id") Integer id){
        reserveService.deleteResOrder(id);
        return "redirect:/admin/resorder";
    }


}

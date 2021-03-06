package com.yiming.hotel_manage.controller.admin;

import com.yiming.hotel_manage.pojo.CheckOrder;
import com.yiming.hotel_manage.pojo.ReserveOrder;
import com.yiming.hotel_manage.pojo.Room;
import com.yiming.hotel_manage.service.CheckService;
import com.yiming.hotel_manage.service.ReserveService;
import com.yiming.hotel_manage.service.RoomService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class OrderManageController {
    @Autowired
    private CheckService checkService;

    @Autowired
    private ReserveService reserveService;

    @Autowired
    private RoomService roomService;

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

    //退房操作(在入住表中更新退房时间)
    @RequestMapping("/admincheckout/{id}/{roomid}")
    public String outCheckTime(@PathVariable("id") Integer id,@PathVariable("roomid") Integer roomId){
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        checkService.outCheckTime(id,ft.format(dNow));
        String stat = "有";
        roomService.updateRoomStat(stat,roomId);
        return "redirect:/admin/checkorder";
    }

    //查询入住订单
    @PostMapping("/admin/getCheckInfo")
    public String getCheckInfo(@RequestParam("orderId") Integer id,Model model){
        CheckOrder checkOrder = checkService.getCheckOrderById(id);
        model.addAttribute("checkorders",checkOrder);
        return "admin/order_check_Manage";
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

    //查询入住订单
    @PostMapping("/admin/getResInfo")
    public String getResInfo(@RequestParam("orderId") Integer id,Model model){
        ReserveOrder reserveOrder = reserveService.getResOrderById(id);
        model.addAttribute("resorders",reserveOrder);
        return "admin/order_reserve_Manage";
    }

    //办理入住（删除预约订单，添加入住订单）
    @RequestMapping("/admincheck/{id}/{account}")
    public String adminCheck(@PathVariable("id") Integer id,
                             @PathVariable("account") String account){
        reserveService.deleteResOrderByRoom(id);
        checkService.addCheckOrder(account,id);
        return "redirect:/admin/resorder";
    }
}

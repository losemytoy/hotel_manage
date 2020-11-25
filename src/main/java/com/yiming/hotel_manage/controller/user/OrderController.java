package com.yiming.hotel_manage.controller.user;

import com.yiming.hotel_manage.pojo.CheckOrder;
import com.yiming.hotel_manage.pojo.ReserveOrder;
import com.yiming.hotel_manage.pojo.User;
import com.yiming.hotel_manage.service.CheckService;
import com.yiming.hotel_manage.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private ReserveService reserveService;

    @Autowired
    private CheckService checkService;

    //显示用户所有预约订单
    @GetMapping("/userreslist/{id}")
    public String getResByUser(@PathVariable("id") String id, Model model){
        List<ReserveOrder> reserveOrders = reserveService.getResByUser(id);
        model.addAttribute("reserveOrders",reserveOrders);
        return "user/user_resorder";
    }

    //取消预定房间  删除预约订单
    @RequestMapping("/userresdel/{id}")
    public String cancelRes(@PathVariable("id") Integer id){
        reserveService.deleteResOrder(id);
        return "redirect:/user/main";
    }

    //显示用户所有预约订单
    @GetMapping("/userchecklist/{id}")
    public String getCheckByUser(@PathVariable("id") String id, Model model){
        List<CheckOrder> checkOrders = checkService.getCheckByUser(id);
        model.addAttribute("checkOrders",checkOrders);
        return "user/user_check";
    }
}

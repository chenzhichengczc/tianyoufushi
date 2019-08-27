package com.clothes.modules.order.controller;

import com.clothes.common.utils.ResponseUtil;
import com.clothes.modules.order.entity.OrderEntity;
import com.clothes.modules.order.entity.OrderForm;
import com.clothes.modules.order.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 16:02
 * @description：
 * @modified By：
 * @version:
 */

@RestController
@Api(tags = "公告")
@RequestMapping("/wx/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 根据订单状态获取订单
     * @return
     */
    @RequestMapping(value = "/order/list", method = RequestMethod.GET)
    public ResponseUtil getOrderList(String openId, Integer status){
        Map<String, List<OrderEntity>> map = new HashMap<>();
        List<OrderEntity> orderList = orderService.orderList(openId, status);
        map.put("orderList", orderList);
        return ResponseUtil.success(map);
    }

    @RequestMapping(value = "/order/detail",method = RequestMethod.GET)
    public ResponseUtil getOrderDetail(String openId, Integer id){
        Map<String, Object> orderDetail = orderService.getOrderDetail(openId, id);
        return ResponseUtil.success(orderDetail);
    }

    @RequestMapping(value = "/order/create", method = RequestMethod.POST)
    public ResponseUtil createOrder(OrderForm orderForm){
        orderService.insertForm(orderForm);
        return  ResponseUtil.success();

    }
    
    @RequestMapping(value = "/order/create/vip", method = RequestMethod.POST)
    public ResponseUtil createOrderVip(OrderEntity orderEntity) {
        System.out.println(orderEntity);
        orderService.insertVipForm(orderEntity);
        return  ResponseUtil.success();

    }
}

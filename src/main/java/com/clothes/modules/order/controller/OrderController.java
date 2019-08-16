package com.clothes.modules.order.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.common.utils.ResponseUtil;
import com.clothes.modules.order.entity.OrderEntity;
import com.clothes.modules.order.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
     * 公告列表
     * @return
     */
    @RequestMapping(value = "/order/statistics", method = RequestMethod.GET)
    public ResponseUtil getOrderList(){

        EntityWrapper<OrderEntity> entityEntityWrapper = new EntityWrapper<>();

        List<OrderEntity> norderEntities = orderService.orderList(entityEntityWrapper);
        return ResponseUtil.success(norderEntities);
    }
}

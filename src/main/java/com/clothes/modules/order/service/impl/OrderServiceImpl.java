package com.clothes.modules.order.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clothes.common.exception.JcException;
import com.clothes.common.utils.OrderStatusUtils;
import com.clothes.modules.order.entity.OrderDetailEntity;
import com.clothes.modules.order.entity.OrderEntity;
import com.clothes.modules.order.entity.OrderGoodsEntity;
import com.clothes.modules.order.mapper.OrderMapper;
import com.clothes.modules.order.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/20 17:26
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    /**
     * 根据订单状态获取当前订单
     * @param openId
     * @param status
     * @return
     */
    public List<OrderEntity> orderList(String openId, Integer status) {
        List<OrderEntity> orderList = orderMapper.getOrderList(openId, status);
        return orderList;
    }

    /**
     * 根据订单Id获取订单详情
     * @param openId
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> getOrderDetail(String openId, Integer id) {
        Map<String, Object> map = new HashMap<>();
        List<OrderGoodsEntity> orderGoods = orderMapper.getOrderGoods(openId, id);
        System.out.println("orderGoods = " + orderGoods);
        map.put("goods", orderGoods);
        OrderDetailEntity orderDetail = orderMapper.getOrderDetail(openId, id);
        if(orderDetail == null){
            throw new JcException("查看订单详情失败");
        }
        String statusStr = OrderStatusUtils.statusStr[orderDetail.getStatus()];
        map.put("statusStr", statusStr);

        map.put("orderInfo", orderDetail);

        return map;
    }
}

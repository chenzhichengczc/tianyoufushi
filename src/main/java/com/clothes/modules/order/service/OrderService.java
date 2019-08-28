package com.clothes.modules.order.service;

import com.clothes.modules.order.entity.OrderEntity;
import com.clothes.modules.order.entity.OrderForm;
import com.clothes.modules.order.entity.OrderListEntity;
import com.clothes.modules.shop.entity.ShopEntity;

import java.util.List;
import java.util.Map;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/20 18:52
 * @description：
 * @modified By：
 * @version:
 */
public interface OrderService {

    public List<OrderListEntity> orderList(String openId, Integer status);

    public Map<String, Object> getOrderDetail(String openId, Integer id);

    public Map<String, Object> insertForm(OrderForm orderForm);

    public void insertVipForm(OrderEntity orderEntity);
}

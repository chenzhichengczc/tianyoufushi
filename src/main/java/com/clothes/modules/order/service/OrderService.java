package com.clothes.modules.order.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.modules.order.entity.OrderEntity;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/14 11:03
 * @description：
 * @modified By：
 * @version:
 */
public interface OrderService {

    public List<OrderEntity> orderList(EntityWrapper<OrderEntity> entityEntityWrapper);
}

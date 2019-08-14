package com.clothes.modules.order.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clothes.modules.order.entity.OrderEntity;
import com.clothes.modules.order.mapper.OrderMapper;
import com.clothes.modules.order.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/14 11:20
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<OrderEntity> orderList(EntityWrapper<OrderEntity> entityEntityWrapper) {
        List<OrderEntity> orderEntities = orderMapper.selectList(entityEntityWrapper);
        return orderEntities;
    }
}

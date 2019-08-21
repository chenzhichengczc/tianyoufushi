package com.clothes.modules.order.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.modules.order.entity.OrderEntity;
import com.clothes.modules.order.entity.StatisticsEntity;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/14 11:03
 * @description：
 * @modified By：
 * @version:
 */
public interface StatisticsService {

    public List<StatisticsEntity> statisticsList(EntityWrapper<StatisticsEntity> entityEntityWrapper, String openId);


}

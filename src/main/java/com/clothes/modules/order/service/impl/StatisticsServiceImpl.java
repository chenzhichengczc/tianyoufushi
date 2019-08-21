package com.clothes.modules.order.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clothes.modules.order.entity.OrderEntity;
import com.clothes.modules.order.entity.StatisticsEntity;
import com.clothes.modules.order.mapper.StatisticsMapper;
import com.clothes.modules.order.service.StatisticsService;
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
public class StatisticsServiceImpl extends ServiceImpl<StatisticsMapper, StatisticsEntity> implements StatisticsService {

    @Resource
    private StatisticsMapper statisticsMapper;

    @Override
    public List<StatisticsEntity> statisticsList(EntityWrapper<StatisticsEntity> entityEntityWrapper, String openId) {
        entityEntityWrapper.eq("open_id", openId);
        List<StatisticsEntity> orderEntities = statisticsMapper.selectList(entityEntityWrapper);
        return orderEntities;
    }


}

package com.clothes.modules.logistics.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.clothes.modules.logistics.entity.LogisticsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author fenghuang
 * @email 
 * @date 2019-08-16 11:45:10
 */
public interface LogisticsService extends IService<LogisticsEntity> {

    public List<LogisticsEntity> logisticsList(EntityWrapper<LogisticsEntity> entityEntityWrapper);
}


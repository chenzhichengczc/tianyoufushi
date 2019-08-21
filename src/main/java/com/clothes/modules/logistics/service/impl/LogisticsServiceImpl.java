package com.clothes.modules.logistics.service.impl;

import com.clothes.modules.logistics.entity.LogisticsEntity;
import com.clothes.modules.logistics.mapper.LogisticsMapper;
import com.clothes.modules.logistics.service.LogisticsService;
import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import javax.annotation.Resource;


@Service
public class LogisticsServiceImpl extends ServiceImpl<LogisticsMapper, LogisticsEntity> implements LogisticsService {

    @Resource
    private LogisticsMapper logisticsMapper;

    public List<LogisticsEntity> logisticsList(EntityWrapper<LogisticsEntity> entityEntityWrapper){
           return  logisticsMapper.selectList(entityEntityWrapper);
    }
}

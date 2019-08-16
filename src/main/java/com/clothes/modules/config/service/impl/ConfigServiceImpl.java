package com.clothes.modules.config.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


import com.clothes.modules.config.mapper.ConfigMapper;
import com.clothes.modules.config.entity.ConfigEntity;
import com.clothes.modules.config.service.ConfigService;

import javax.annotation.Resource;


@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, ConfigEntity> implements ConfigService {

    @Resource
    private ConfigMapper configMapper;





    public List<ConfigEntity> configList(EntityWrapper<ConfigEntity> entityEntityWrapper, String key){

        entityEntityWrapper.eq("key", key);
           return  configMapper.selectList(entityEntityWrapper);


    }



}

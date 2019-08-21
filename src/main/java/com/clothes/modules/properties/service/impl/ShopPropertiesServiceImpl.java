package com.clothes.modules.properties.service.impl;

import com.clothes.modules.properties.entity.ShopPropertiesEntity;
import com.clothes.modules.properties.mapper.ShopPropertiesMapper;
import com.clothes.modules.properties.service.ShopPropertiesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import javax.annotation.Resource;


@Service
public class ShopPropertiesServiceImpl extends ServiceImpl<ShopPropertiesMapper, ShopPropertiesEntity> implements ShopPropertiesService {

    @Resource
    private ShopPropertiesMapper shopPropertiesMapper;

    



    public List<ShopPropertiesEntity> shopPropertiesList(EntityWrapper<ShopPropertiesEntity> entityEntityWrapper){

           return  shopPropertiesMapper.selectList(entityEntityWrapper);


    }



}

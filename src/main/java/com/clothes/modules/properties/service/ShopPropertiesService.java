package com.clothes.modules.properties.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.clothes.modules.properties.entity.ShopPropertiesEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author fenghuang
 * @email 
 * @date 2019-08-16 11:19:33
 */
public interface ShopPropertiesService extends IService<ShopPropertiesEntity> {

    public List<ShopPropertiesEntity> shopPropertiesList(EntityWrapper<ShopPropertiesEntity> entityEntityWrapper);
}


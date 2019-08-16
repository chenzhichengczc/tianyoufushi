package com.clothes.modules.shop.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clothes.modules.shop.entity.ShopEntity;
import com.clothes.modules.shop.mapper.ShopMapper;
import com.clothes.modules.shop.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, ShopEntity> implements ShopService {

    @Resource
    private ShopMapper shopMapper;

    @Override
    public List<ShopEntity> getList(EntityWrapper<ShopEntity> wrapper) {
        List<ShopEntity> entityList=shopMapper.selectList(wrapper);
        return entityList;
    }

    @Override
    public List<ShopEntity> getUserStorage(String openId) {
        List<ShopEntity> userStorage = shopMapper.getUserStorage(openId);
        return userStorage;
    }

}

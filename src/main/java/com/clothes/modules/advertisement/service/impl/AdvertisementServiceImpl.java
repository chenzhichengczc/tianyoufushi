package com.clothes.modules.advertisement.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clothes.modules.advertisement.entity.AdvertisementEntity;
import com.clothes.modules.advertisement.mapper.AdvertisementMapper;
import com.clothes.modules.advertisement.service.AdvertisementService;
import com.clothes.modules.shop.entity.ShopEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdvertisementServiceImpl extends ServiceImpl<AdvertisementMapper, AdvertisementEntity> implements AdvertisementService{
    @Resource
    private AdvertisementMapper advertisementMapper;

    @Override
    public AdvertisementEntity getAdvertisement(Integer bannerId) {
        AdvertisementEntity Advertisement = advertisementMapper.getAdvertisement(bannerId);
        return Advertisement;
    }

    @Override
    public List<ShopEntity> getAdvertisementShop(Integer shopId) {
        List<ShopEntity> shop = advertisementMapper.getAdvertisementShop(shopId);
        return shop;
    }
}

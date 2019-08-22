package com.clothes.modules.advertisement.service;

import com.baomidou.mybatisplus.service.IService;
import com.clothes.modules.advertisement.entity.AdvertisementEntity;
import com.clothes.modules.shop.entity.ShopEntity;

import java.util.List;

public interface AdvertisementService extends IService<AdvertisementEntity> {


   public AdvertisementEntity getAdvertisement(Integer bannerId);

   public List<ShopEntity> getAdvertisementShop(Integer shopId);
}

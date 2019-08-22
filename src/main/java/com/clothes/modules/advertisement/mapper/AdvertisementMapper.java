package com.clothes.modules.advertisement.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.clothes.modules.advertisement.entity.AdvertisementEntity;
import com.clothes.modules.shop.entity.ShopEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdvertisementMapper extends BaseMapper<AdvertisementEntity> {
    AdvertisementEntity getAdvertisement(@Param(value = "bannerId") Integer bannerId);

    List<ShopEntity> getAdvertisementShop(@Param(value = "shopId") Integer shopId);
}

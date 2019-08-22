package com.clothes.modules.advertisement.controller;

import com.clothes.common.utils.ResponseUtil;
import com.clothes.modules.advertisement.entity.AdvertisementEntity;
import com.clothes.modules.advertisement.service.AdvertisementService;
import com.clothes.modules.shop.entity.ShopEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/wx/api")
public class AdvertisementController {
    @Resource
    private AdvertisementService advertisementService;

    @RequestMapping(value = "/advertisement/home",method = RequestMethod.GET)
    public ResponseUtil AdvertisementHome(Integer bannerId){
        AdvertisementEntity advertisementEntity = advertisementService.getAdvertisement(bannerId);
        return ResponseUtil.success(advertisementEntity);
    }

    @RequestMapping(value = "/advertisement/shop",method = RequestMethod.GET)
    public ResponseUtil AdvertisementShop(Integer shopId){
        List<ShopEntity> AdvertisementShop = advertisementService.getAdvertisementShop(shopId);
        return ResponseUtil.success(AdvertisementShop);
    }
}

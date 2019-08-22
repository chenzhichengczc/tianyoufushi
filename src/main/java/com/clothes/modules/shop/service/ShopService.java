package com.clothes.modules.shop.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.clothes.modules.shop.entity.ShopDetailVO;
import com.clothes.modules.shop.entity.ShopEntity;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/5/22 14:55
 * @description：
 * @modified By：
 * @version:
 */
public interface ShopService extends IService<ShopEntity>{

    List<ShopEntity> getList(EntityWrapper<ShopEntity> wrapper);

    public List<ShopEntity> getUserStorage(String openId);

    public ShopDetailVO getShopDetail(EntityWrapper<ShopEntity> wrapper, Integer id);

    void addFavShop(String openId, Integer goodsId);

    void deleteFavShop(String openId, Integer goodsId);
}

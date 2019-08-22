package com.clothes.modules.shop.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.clothes.modules.shop.entity.ShopEntity;
import com.clothes.modules.shop.entity.ShopUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/5/22 14:53
 * @description：
 * @modified By：
 * @version:
 */

public interface ShopMapper extends BaseMapper<ShopEntity> {

    public List<ShopEntity> getUserStorage(@Param(value = "openId") String openId);

    void addFavShop(ShopUser shopUser);

    void deleteFavShop(@Param(value = "openId")String openId, @Param(value = "goodsId")Integer goodsId);


}

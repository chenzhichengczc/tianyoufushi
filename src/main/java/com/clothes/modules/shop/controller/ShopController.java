package com.clothes.modules.shop.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.common.utils.ResponseUtil;
import com.clothes.modules.shop.entity.ShopDetailVO;
import com.clothes.modules.shop.entity.ShopEntity;
import com.clothes.modules.shop.service.ShopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/wx/api")
public class ShopController {

    @Resource
    private ShopService shopService;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/shop/goods/list",method = RequestMethod.GET)
    public ResponseUtil shopEntityList(int recommendStatus, int pageSize){
        PageHelper.startPage(recommendStatus, pageSize);
        EntityWrapper<ShopEntity> wrapper = new EntityWrapper<ShopEntity>();
        List<ShopEntity> pageList =shopService.getList(wrapper,recommendStatus);
        PageInfo<ShopEntity> pageInfo=new PageInfo<>(pageList);
        return ResponseUtil.success(pageInfo);
    }

    @RequestMapping(value = "/shop/goods/fav/list",method = RequestMethod.GET)
    public ResponseUtil shopUserStorageList(String openId){
        List<ShopEntity> userStorage = shopService.getUserStorage(openId);
        return ResponseUtil.success(userStorage);
    }
    @RequestMapping(value="/shop/goods/fav/add",method = RequestMethod.POST)
    public ResponseUtil shopFavAdd(String openId,Integer goodsId){
        shopService.addFavShop(openId,goodsId);
        return ResponseUtil.success();
    }
    @RequestMapping(value="/shop/goods/fav/delete",method = RequestMethod.POST)
    public ResponseUtil shopFavDelete(String openId,Integer goodsId){
        shopService.deleteFavShop(openId,goodsId);
        return ResponseUtil.success();
    }
    @RequestMapping(value = "/shop/goods/detail", method = RequestMethod.GET)
    public ResponseUtil getShopDetail(Integer id){
        EntityWrapper<ShopEntity> wrapper = new EntityWrapper<ShopEntity>();
        ShopDetailVO shopDetailVO = shopService.getShopDetail(wrapper,id);
        return ResponseUtil.success(shopDetailVO);
    }
}

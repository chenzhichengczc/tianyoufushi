package com.clothes.modules.shop.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.common.utils.ResponseUtil;
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
@RequestMapping("/shop")
public class ShoopController {

    @Resource
    private ShopService shopService;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/goods/list",method = RequestMethod.GET)
    public ResponseUtil shoopEntityList(int recommendStatus, int pageSize){
        PageHelper.startPage(recommendStatus, pageSize);
        EntityWrapper<ShopEntity> wrapper = new EntityWrapper<ShopEntity>();
        List<ShopEntity> pageList =shopService.getList(wrapper);
        PageInfo<ShopEntity> pageInfo=new PageInfo<>(pageList);
        return ResponseUtil.success(pageInfo);
    }
}

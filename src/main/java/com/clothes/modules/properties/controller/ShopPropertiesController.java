package com.clothes.modules.properties.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.common.utils.ResponseUtil;
import com.clothes.modules.properties.entity.ShopPropertiesEntity;
import com.clothes.modules.properties.service.ShopPropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 
 *
 * @author fenghuang
 * @email 
 * @date 2019-08-16 11:19:33
 */
@RestController
@RequestMapping("/wx/api")
public class ShopPropertiesController {
    @Autowired
    private ShopPropertiesService shopPropertiesService;

    /**
     * 列表
     */
    @RequestMapping(value = "/properties/shopProperties", method = RequestMethod.GET)
    public ResponseUtil list(@RequestParam Map<String, Object> params){
        EntityWrapper<ShopPropertiesEntity> entityEntityWrapper = new EntityWrapper<>();
        List<ShopPropertiesEntity> shopPropertiesEntities = shopPropertiesService.shopPropertiesList(entityEntityWrapper);
        return ResponseUtil.success(shopPropertiesEntities);
    }




}

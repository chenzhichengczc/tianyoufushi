package com.clothes.modules.discounts.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.common.utils.ResponseUtil;
import com.clothes.modules.discounts.entity.DiscountsEntity;
import com.clothes.modules.discounts.service.DiscountsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 16:02
 * @description：
 * @modified By：
 * @version:
 */

@RestController
@Api(tags = "公告")
@RequestMapping("/wx")
public class DiscountsController {

    @Autowired
    private DiscountsService discountsService;

    /**
     * 公告列表
     * @return
     */
    @RequestMapping(value = "/discounts/my", method = RequestMethod.GET)
    public ResponseUtil getDiscountsList(String openId){

        EntityWrapper<DiscountsEntity> entityEntityWrapper = new EntityWrapper<>();

        List<DiscountsEntity> discountsEntities = discountsService.discountsList(entityEntityWrapper);
        return ResponseUtil.success(discountsEntities);
    }

    @RequestMapping(value = "discounts/fetchById", method = RequestMethod.GET)
    public ResponseUtil fetchDiscounts(String openId, Integer pwd){


        return ResponseUtil.success();
    }

    @RequestMapping(value = "discounts/fetch", method = RequestMethod.GET)
    public ResponseUtil fetch(String openId, Integer id){


        return ResponseUtil.success();
    }

}

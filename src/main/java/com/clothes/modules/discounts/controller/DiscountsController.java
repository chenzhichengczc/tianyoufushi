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
@Api(tags = "优惠")
@RequestMapping("/wx/api")
public class DiscountsController {

    @Autowired
    private DiscountsService discountsService;

    /**
     * 公告列表
     * @return
     */
    @RequestMapping(value = "/discounts/my", method = RequestMethod.GET)
    public ResponseUtil getDiscountsList(String openId,Integer status){
        EntityWrapper<DiscountsEntity> entityEntityWrapper = new EntityWrapper<>();
        List<DiscountsEntity> discountsEntities = discountsService.discountsList(entityEntityWrapper,openId,status);
        return ResponseUtil.success(discountsEntities);
    }

    /**
     * 根据id进行兑换至自己账户
     * @param openId
     * @param id
     * @return
     */
    @RequestMapping(value = "/discounts/fetchById", method = RequestMethod.POST)
    public ResponseUtil fetchDiscounts(String openId, Integer id){
        //返回状态code 20001/20002兑换完毕 20003领取过了 30001 积分不够  20004 礼券过期 0 成功
        Integer code = discountsService.fetchDiscounts(openId,id);
        return ResponseUtil.success(code,"");
    }

    @RequestMapping(value = "/discounts/fetch", method = RequestMethod.POST)
    public ResponseUtil fetch(String openId, String pwd){
        //返回状态code 20001/20002兑换完毕 20003领取过了 20000 兑换码错误  0 成功
        Integer code = discountsService.fetch(openId,pwd);
        return ResponseUtil.success(code,"");
    }

}

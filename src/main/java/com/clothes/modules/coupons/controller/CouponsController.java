package com.clothes.modules.coupons.controller;

import com.clothes.common.utils.ResponseUtil;
import com.clothes.modules.coupons.service.CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-08-14 14:30:47
 */
@RestController
@RequestMapping("/wx/api")
public class CouponsController {
    @Autowired
    private CouponsService couponsService;

    /**
     * 列表
     */
    @RequestMapping(value = "/discounts/coupons", method = RequestMethod.GET)
    public ResponseUtil getListForType(String openId, String type){

     return ResponseUtil.success(couponsService.getBannerEntityList(type));

    }
}

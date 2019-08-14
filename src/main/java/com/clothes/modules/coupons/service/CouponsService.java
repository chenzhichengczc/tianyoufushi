package com.clothes.modules.coupons.service;

import com.baomidou.mybatisplus.service.IService;
import com.clothes.modules.coupons.entity.CouponsEntity;

import java.util.List;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-08-14 14:30:47
 */
public interface CouponsService extends IService<CouponsEntity> {

    List<CouponsEntity> getBannerEntityList(String type);
}


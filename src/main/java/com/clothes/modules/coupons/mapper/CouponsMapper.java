package com.clothes.modules.coupons.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.clothes.modules.coupons.entity.CouponsEntity;

import java.util.List;

/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-08-14 14:30:47
 */
public interface CouponsMapper extends BaseMapper<CouponsEntity> {

    List<CouponsEntity> selectByType(String type);
}

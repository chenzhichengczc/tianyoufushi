package com.clothes.modules.discounts.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.modules.discounts.entity.DiscountsEntity;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 16:25
 * @description：
 * @modified By：
 * @version:
 */
public interface DiscountsService {

    public List<DiscountsEntity> discountsList(EntityWrapper<DiscountsEntity> entityEntityWrapper);
}

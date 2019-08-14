package com.clothes.modules.discounts.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clothes.modules.discounts.entity.DiscountsEntity;
import com.clothes.modules.discounts.mapper.DiscountsMapper;
import com.clothes.modules.discounts.service.DiscountsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 16:26
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class DiscountsServiceImpl extends ServiceImpl<DiscountsMapper, DiscountsEntity> implements DiscountsService {

    @Resource
    private DiscountsMapper discountsMapper;

    /**
     * 獲取公告impl
     * @return
     */

    public List<DiscountsEntity> discountsList(EntityWrapper<DiscountsEntity> entityEntityWrapper) {
        List<DiscountsEntity> discountsEntities = discountsMapper.selectList(entityEntityWrapper);
        return discountsEntities;
    }
}

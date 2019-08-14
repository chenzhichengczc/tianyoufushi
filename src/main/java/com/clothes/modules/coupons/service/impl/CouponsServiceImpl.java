package com.clothes.modules.coupons.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clothes.modules.coupons.entity.CouponsEntity;
import com.clothes.modules.coupons.mapper.CouponsMapper;
import com.clothes.modules.coupons.service.CouponsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CouponsServiceImpl extends ServiceImpl<CouponsMapper, CouponsEntity> implements CouponsService {

    @Resource
    private CouponsMapper couponsMapper;


    @Override
    public List<CouponsEntity> getBannerEntityList(String type) {
        List<CouponsEntity> couponsEntities=couponsMapper.selectByType(type);
        return couponsEntities;
    }
}

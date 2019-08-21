package com.clothes.modules.banner.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clothes.modules.banner.entity.BannerEntity;
import com.clothes.modules.banner.mapper.BannerMapper;
import com.clothes.modules.banner.service.BannerService;
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
public class BannerServiceImpl extends ServiceImpl<BannerMapper, BannerEntity> implements BannerService {

    @Resource
    private BannerMapper bannerMapper;


    @Override
    public List<BannerEntity> getBannerEntityList(String type,String key) {
        EntityWrapper<BannerEntity> entityEntityWrapper = new EntityWrapper<BannerEntity>();
        entityEntityWrapper.eq("type",type);
        if(key != null) { entityEntityWrapper.eq("`key`",key); }
        List<BannerEntity> bannerEntities = bannerMapper.selectList(entityEntityWrapper);
        return bannerEntities;
    }
}

package com.clothes.modules.banner.service;


import com.clothes.modules.banner.entity.BannerEntity;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 16:25
 * @description：
 * @modified By：
 * @version:
 */
public interface BannerService {


    List<BannerEntity> getBannerEntityList(String type,String key);
}

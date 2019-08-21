package com.clothes.modules.pics.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.clothes.modules.pics.entity.PicsEntity;


import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author fenghuang
 * @email 
 * @date 2019-08-16 11:17:09
 */
public interface PicsService extends IService<PicsEntity> {

    public List<PicsEntity> picsList(EntityWrapper<PicsEntity> entityEntityWrapper);
}


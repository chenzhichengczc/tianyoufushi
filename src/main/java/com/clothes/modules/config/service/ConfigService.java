package com.clothes.modules.config.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.clothes.modules.config.entity.ConfigEntity;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author fenghuang
 * @email
 * @date 2019-08-15 16:34:48
 */
public interface ConfigService extends IService<ConfigEntity> {

    public List<ConfigEntity> configList(EntityWrapper<ConfigEntity> entityEntityWrapper, String key);
}


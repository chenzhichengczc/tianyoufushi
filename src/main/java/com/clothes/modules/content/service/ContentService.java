package com.clothes.modules.content.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.clothes.modules.content.entity.ContentEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author fenghuang
 * @email 
 * @date 2019-08-16 11:18:11
 */
public interface ContentService extends IService<ContentEntity> {

    public List<ContentEntity> contentList(EntityWrapper<ContentEntity> entityEntityWrapper);
}


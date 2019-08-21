package com.clothes.modules.category.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.clothes.modules.category.entity.CategoryEntity;

import java.util.List;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-08-14 15:48:07
 */
public interface CategoryService extends IService<CategoryEntity> {

    public List<CategoryEntity> amountList(EntityWrapper<CategoryEntity> entityEntityWrapper);
}


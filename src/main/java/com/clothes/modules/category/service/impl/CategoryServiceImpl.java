package com.clothes.modules.category.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clothes.modules.category.entity.CategoryEntity;
import com.clothes.modules.category.mapper.CategoryMapper;
import com.clothes.modules.category.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CategoryServiceImpl extends ServiceImpl<com.clothes.modules.category.mapper.CategoryMapper, CategoryEntity> implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;


    @Override
    public List<CategoryEntity> amountList(EntityWrapper<CategoryEntity> entityEntityWrapper) {
        List<CategoryEntity> noticeEntities = categoryMapper.selectList(entityEntityWrapper);
        return noticeEntities;
    }
   
        @Override
    public List<ShopEntity> getListById(Integer categoryId,EntityWrapper<ShopEntity> entityEntityWrapper) {
        return shopMapper.selectList(entityEntityWrapper.eq("category_id",categoryId));
    }
}

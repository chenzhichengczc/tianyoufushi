package com.clothes.modules.category.controller;


import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.common.utils.ResponseUtil;
import com.clothes.modules.category.entity.CategoryEntity;
import com.clothes.modules.category.service.CategoryService;
import com.clothes.modules.shop.entity.ShopEntity;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-08-14 15:48:07
 */
@RestController
@RequestMapping("/wx/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/shop/goods/category/all", method = RequestMethod.GET)
    public ResponseUtil getCategoryList(){

        EntityWrapper<CategoryEntity> entityEntityWrapper = new EntityWrapper<>();

        List<CategoryEntity> categoryEntities = categoryService.amountList(entityEntityWrapper);
        return ResponseUtil.success(categoryEntities);
    }
   
     @RequestMapping(value = "/shop/goods/listByCategoryId",method = RequestMethod.GET)
    public ResponseUtil getListById(Integer categoryId , Integer pageSize){
        PageHelper.startPage(1,pageSize);
        EntityWrapper<ShopEntity> wrapper = new EntityWrapper<ShopEntity>();
        List<ShopEntity> list = categoryService.getListById(categoryId,wrapper);
        return ResponseUtil.success(list);
    }

}

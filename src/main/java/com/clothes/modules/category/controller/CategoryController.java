package com.clothes.modules.category.controller;


import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.common.utils.ResponseUtil;
import com.clothes.modules.category.entity.CategoryEntity;
import com.clothes.modules.category.service.CategoryService;
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
@RequestMapping("/shop")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/goods/category/all", method = RequestMethod.GET)
    public ResponseUtil getCategoryList(){

        EntityWrapper<CategoryEntity> entityEntityWrapper = new EntityWrapper<>();

        List<CategoryEntity> categoryEntities = categoryService.amountList(entityEntityWrapper);
        return ResponseUtil.success(categoryEntities);
    }


}

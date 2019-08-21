package com.clothes.modules.shop.entity;

import com.clothes.modules.category.entity.CategoryEntity;
import com.clothes.modules.content.entity.ContentEntity;
import com.clothes.modules.logistics.entity.LogisticsEntity;
import com.clothes.modules.pics.entity.PicsEntity;
import com.clothes.modules.properties.entity.ShopPropertiesEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Charles Chan
 * @Date: 2019/8/16 11:14
 * @Version 1.0
 * 商品详情表
 */
@Data
@Component

public class ShopDetailVO {

    @JsonProperty(value = "basicInfo")
    private ShopEntity shopEntity;

    @JsonProperty(value = "category")
    private CategoryEntity categoryEntity;

    @JsonProperty(value = "pics")
    private List<PicsEntity> picsEntity;

    @JsonProperty(value = "content")
    private ContentEntity contentEntity;

    @JsonProperty(value = "properties")
    private List<ShopPropertiesEntity> shopPropertiesEntity;

    @JsonProperty(value = "logistics")
    private LogisticsEntity logisticsEntity;

    public ShopDetailVO(){

    }

    public ShopDetailVO(ShopEntity shopEntity, CategoryEntity categoryEntity, List<PicsEntity> picsEntity, ContentEntity contentEntity, List<ShopPropertiesEntity> shopPropertiesEntity, LogisticsEntity logisticsEntity) {
        this.shopEntity = shopEntity;
        this.categoryEntity = categoryEntity;
        this.picsEntity = picsEntity;
        this.contentEntity = contentEntity;
        this.shopPropertiesEntity = shopPropertiesEntity;
        this.logisticsEntity = logisticsEntity;
    }
}

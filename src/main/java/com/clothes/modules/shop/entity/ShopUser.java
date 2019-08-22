package com.clothes.modules.shop.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class ShopUser {
    private Integer id;
    private Integer goodsId;
    private Date dateAdd;
    private String userId;


}

package com.clothes.modules.advertisement.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class AdvertisementEntity {
    private Integer id;
    private Integer bannerId;
    private String picUrl;
    private String details;
    private String theme;
    private Integer status;
    private String statusStr;
    private Date dateAdd;
    private Date dateUpdate;
    private Integer shopId;
}

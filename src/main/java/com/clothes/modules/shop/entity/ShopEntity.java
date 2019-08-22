package com.clothes.modules.shop.entity;

import cn.hutool.db.DaoTemplate;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.clothes.basic.BasicEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel("分页图片展览")
@Data
@TableName("shop")
public class ShopEntity {

    @ApiModelProperty(value = "自增ID",name = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "",name="barCode")
    @TableField("bar_code")
    private String barCode;

    @ApiModelProperty(value = "套餐",name="categoryId")
    @TableField("category_id")
    private Integer categoryId;

    @ApiModelProperty(value = "成交金额",name="characteristic")
    private String characteristic;

    @ApiModelProperty(value = "姓名",name="commission")
    private Integer commission;

    @ApiModelProperty(value = "成交金额",name="commissionType")
    @TableField("commission_type")
    private Integer commissionType;

    @ApiModelProperty(value = "姓名",name="dateAdd")

    private Date dateAdd;

    @ApiModelProperty(value = "姓名",name="dateStart")

    private Date dateStart;

    @ApiModelProperty(value = "姓名",name="dateUpdate")

    private Date dateUpdate;

    @ApiModelProperty(value = "成交金额",name="gotScore")

    private Integer gotScore;

    @ApiModelProperty(value = "姓名",name="gotScoreType")

    private Integer gotScoreType;

    @ApiModelProperty(value = "成交金额",name="kanjia")
    private String kanjia;

    @ApiModelProperty(value = "姓名",name="kanjiaPrice")
    private Integer kanjiaPrice;

    @ApiModelProperty(value = "成交金额",name="limitation")
    private String limitation;

    @ApiModelProperty(value = "姓名",name="logisticsId")
    private Integer logisticsId;

    @ApiModelProperty(value = "成交金额",name="miaosha")
    private String miaosha;

    @ApiModelProperty(value = "姓名",name="minPrice")
    private Integer minPrice;

    @ApiModelProperty(value = "成交金额",name="minScore")
    private Integer minScore;

    @ApiModelProperty(value = "姓名",name="name")
    private String name;

    @ApiModelProperty(value = "成交金额",name="numberFav")
    private Integer numberFav;

    @ApiModelProperty(value = "姓名",name="numberGoodReputation")
    private Integer numberGoodReputation;

    @ApiModelProperty(value = "成交金额",name="numberOrders")
    private Integer numberOrders;

    @ApiModelProperty(value = "姓名",name="numberSells")
    private Integer numberSells;

    @ApiModelProperty(value = "成交金额",name="originalPrice")
    private Integer originalPrice;

    @ApiModelProperty(value = "姓名",name="name")
    private Integer paixu;

    @ApiModelProperty(value = "姓名",name="pic")
    private String pic;

    @ApiModelProperty(value = "姓名",name="pingtuan")
    private String pingtuan;

    @ApiModelProperty(value = "姓名",name="pingtuanPrice")
    private Integer pingtuanPrice;

    private Integer propertyIds;

    @ApiModelProperty(value = "姓名",name="recommendStatus")
    private Integer recommendStatus;

    @ApiModelProperty(value = "姓名",name="recommendStatusStr")
    private String recommendStatusStr;

    @ApiModelProperty(value = "姓名",name="shopId")
    private Integer shopId;

    @ApiModelProperty(value = "姓名",name="status")
    private Integer status;

    @ApiModelProperty(value = "姓名",name="statusStr")
    private String statusStr;

    @ApiModelProperty(value = "姓名",name="stores")
    private Integer stores;

    @ApiModelProperty(value = "姓名",name="userId")
    private Integer userId;

    @ApiModelProperty(value = "姓名",name="videoId")
    private String videoId;

    @ApiModelProperty(value = "姓名",name="views")
    private Integer views;

    @ApiModelProperty(value = "姓名",name="weight")
    private Integer weight;
}
package com.clothes.modules.discounts.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 16:22
 * @description：
 * @modified By：
 * @version:
 */
@Data
@TableName("discounts")
public class DiscountsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增ID",name = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "优惠券ID",name = "couponsId")
    @TableField("coupons_id")
    private Integer couponsId;

    @ApiModelProperty(value = "openId",name = "openId")
    @TableField("open_id")
    private String openId;

    @ApiModelProperty(value = "金额",name="money")
    @TableField("money")
    private Float money;

    @ApiModelProperty(value = "名字",name="name")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "使用上限额",name="moneyHrehold")
    @TableField("money_hrehold")
    private Float moneyHrehold;


    @ApiModelProperty(value = "期限",name="dateEnd")
    @TableField("date_end")
    private Date dateEnd;

    @ApiModelProperty(value = "状态",name="status")
    @TableField("status")
    private Integer status;
}

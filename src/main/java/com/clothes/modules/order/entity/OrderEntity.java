package com.clothes.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/20 17:11
 * @description：
 * @modified By：
 * @version:
 */
@Data
@TableName("order_user")
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增ID",name = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "图片",name="pic")
    @TableField("pic")
    private String pic;

    @ApiModelProperty(value = "状态",name="status")
    @TableField("status")
    private String status;

    @ApiModelProperty(value = "订单号",name="orderNumber")
    @TableField("order_number")
    private String orderNumber;

    @ApiModelProperty(value = "合计",name="amountReal")
    @TableField("amount_real")
    private BigDecimal actualPrice;

    @ApiModelProperty(value = "备注",name="remark")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "订单类别id",name="oderStatisticsId")
    @TableField("order_statistics_id")
    private String orderStatisticsId;

    @ApiModelProperty(value = "商品id",name="shopId")
    @TableField("shop_id")
    private Integer shopId;

    @ApiModelProperty(value = "创建时间",name="createTime")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间",name="updateTime")
    @TableField("update_time")
    private Date updateTime;

}

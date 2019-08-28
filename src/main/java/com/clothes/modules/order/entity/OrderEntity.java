package com.clothes.modules.order.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.sf.json.JSONArray;

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


    @ApiModelProperty(value = "状态",name="status")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "订单号",name="orderOn")
    @TableField("order_on")
    private String orderOn;

    @ApiModelProperty(value = "商品費用",name="goodsPrice")
    @TableField("goods_price")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "合计",name="actualPrice")
    @TableField("actual_price")
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

    @ApiModelProperty(value = "openId",name="openId")
    @TableField("open_id")
    private String openId;

    @ApiModelProperty(value = "payId",name="payId")
    @TableField("pay_id")
    private String payId;

    @ApiModelProperty(value = "addressId",name="addressId")
    @TableField("address_id")
    private Integer addressId;

    @ApiModelProperty(value = "创建时间",name="createTime")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间",name="updateTime")
    @TableField("update_time")
    private Date updateTime;



}

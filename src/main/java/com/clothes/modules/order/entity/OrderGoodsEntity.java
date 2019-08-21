package com.clothes.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.clothes.modules.shop.entity.ShopEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/21 15:38
 * @description：
 * @modified By：
 * @version:
 */
@Data
public class OrderGoodsEntity extends ShopEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增ID",name = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单id",name="orderId")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty(value = "商品id",name="shopId")
    @TableField("shop_id")
    private Integer shopId;

    @ApiModelProperty(value = "商品数量",name="number")
    @TableField("number")
    private Integer number;

    @ApiModelProperty(value = "创建时间",name="createTime")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间",name="updateTime")
    @TableField("update_time")
    private Date updateTime;


}

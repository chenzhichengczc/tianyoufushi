package com.clothes.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/21 16:21
 * @description：
 * @modified By：
 * @version:
 */
@Data
public class OrderDetailEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增ID",name = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单号",name="orderOn")
    private String orderOn;
    /**
     * 联系人
     */
    private String linkMan;
    /**
     * 电话
     */
    private String mobile;

    /**
     * 地址
     */
    private String address;

    @ApiModelProperty(value = "状态",name="status")
    @TableField("status")
    private Integer status;


    @ApiModelProperty(value = "商品金额",name="goodsPrice")
    @TableField("goods_price")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "实付金额",name="actualPrice")
    @TableField("actual_price")
    private BigDecimal actualPrice;




}

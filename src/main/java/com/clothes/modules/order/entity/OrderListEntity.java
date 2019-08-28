package com.clothes.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/28 15:10
 * @description：
 * @modified By：
 * @version:
 */
@Data
public class OrderListEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增ID",name = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "状态",name="status")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "数量",name="number")
    @TableField("number")
    private Integer number;

    @ApiModelProperty(value = "订单号",name="orderOn")
    @TableField("order_on")
    private String orderOn;

    @ApiModelProperty(value = "pic",name="pic")
    @TableField("pic")
    private String pic;

    @ApiModelProperty(value = "备注",name="remark")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "创建时间",name="createTime")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "价格",name="goodsPrice")
    private BigDecimal minPrice;

}

package com.clothes.modules.amount.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 16:22
 * @description：
 * @modified By：
 * @version:
 */
@Data
@TableName("user_amount")
public class AmountEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增ID",name = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "公告",name="balance")
    @TableField("balance")
    private Integer balance;

    @ApiModelProperty(value = "公告",name="freeze")
    @TableField("freeze")
    private Integer freeze;

    @ApiModelProperty(value = "公告",name="score")
    @TableField("score")
    private Integer score;

    @ApiModelProperty(value = "openId",name="openId")
    @TableField("open_id")
    private String openId;

}

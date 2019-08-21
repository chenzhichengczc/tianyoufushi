package com.clothes.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/14 11:05
 * @description：
 * @modified By：
 * @version:
 */
@Data
@TableName("order_statistics")
public class StatisticsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增ID",name = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "公告",name="noplay")
    @TableField("noplay")
    private String noplay;

    @ApiModelProperty(value = "公告",name="notransfer")
    @TableField("notransfer")
    private String notransfer;

    @ApiModelProperty(value = "公告",name="noconfirm")
    @TableField("noconfirm")
    private String noconfirm;

    @ApiModelProperty(value = "公告",name="noreputation")
    @TableField("noreputation")
    private String noreputation;

    @ApiModelProperty(value = "openId",name="openId")
    @TableField("open_id")
    private String openId;

}

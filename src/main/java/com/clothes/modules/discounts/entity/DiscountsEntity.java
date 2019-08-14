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

    @ApiModelProperty(value = "公告",name="money")
    @TableField("money")
    private Integer money;

    @ApiModelProperty(value = "公告",name="name")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "公告",name="moneyHrehold")
    @TableField("money_hrehold")
    private Integer moneyHrehold;


    @ApiModelProperty(value = "公告",name="dateEnd")
    @TableField("date_end")
    private Date dateEnd;
}

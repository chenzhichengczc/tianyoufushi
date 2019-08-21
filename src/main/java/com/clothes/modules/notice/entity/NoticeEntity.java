package com.clothes.modules.notice.entity;

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
@TableName("notice")
public class NoticeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增ID",name = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "公告题目",name="title")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "类型",name="type")
    @TableField("type")
    private String type;

}

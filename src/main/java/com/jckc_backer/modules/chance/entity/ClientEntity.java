package com.jckc_backer.modules.chance.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.jckc_backer.basic.BasicEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@TableName("client_information")
@Data
@ApiModel("全部客户信息表")
public class ClientEntity extends BasicEntity {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键",name="uid")
    private Integer uid;

    @ApiModelProperty(value="客户名称",name="clientName")
    @TableField(value = "client_name")
    private String clientName;

    @ApiModelProperty(value="类型",name="type")
    private String type;

    @ApiModelProperty(value="所在城市",name="local")
    private String local;

    @ApiModelProperty(value="具体地址",name="address")
    private String address;

    @ApiModelProperty(value="成熟度",name="maturity")
    private String maturity;

    @ApiModelProperty(value="座机",name="phone")
    private String phone;

    @ApiModelProperty(value="需求",name="need")
    private String need;


    @ApiModelProperty(value="状态",name="state")
    private String state;

    @ApiModelProperty(value="跟进时间",name="followTime")
    @TableField(value = "follow_time")
    private String followTime;

}

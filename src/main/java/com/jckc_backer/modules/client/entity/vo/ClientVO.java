package com.jckc_backer.modules.client.entity.vo;

import com.jckc_backer.modules.client.entity.po.ClientPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/5/23 10:36
 * @description：
 * @modified By：
 * @version:
 */
@ApiModel("客户信息汇总表视图实体类")
@Data
public class ClientVO extends ClientPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id",name = "id")
    private Integer id;

    @ApiModelProperty(value = "客户所属类型",name = "clientType")
    private String clientType;

    @ApiModelProperty(value = "客户名字",name = "clientName")
    private String clientName;

    @ApiModelProperty(value = "客户类型",name = "type")
    private String type;

    @ApiModelProperty(value = "客户状态",name = "status")
    private String status;

    @ApiModelProperty(value = "客户等级",name = "grade")
    private String grade;

    @ApiModelProperty(value = "客户来源",name = "source")
    private String source;

    @ApiModelProperty(value = "成熟度",name = "muturity")
    private String muturity;

    @ApiModelProperty(value = "意向产id",name = "pro_Id")
    private Integer proId;

    @ApiModelProperty(value = "客户介绍",name = "introduction")
    private String introduction;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "获取客户时间",name = "access_time")
    private Date accessTime;

    @ApiModelProperty(value = "所有者",name = "owner")
    private String owner;

    @ApiModelProperty(value = "公司编号",name = "companyCode")
    private String companyCode;

    @ApiModelProperty(value = "公司名称",name = "companyName")
    private String companyName;

    @ApiModelProperty(value = "公司所属行业",name = "industry")
    private String industry;

    @ApiModelProperty(value = "公司座机",name = "tel")
    private String tel;

    @ApiModelProperty(value = "公司地址",name = "address")
    private String address;

    @ApiModelProperty(value = "公司所在城市",name = "companyCity")
    private String companyCity;


}

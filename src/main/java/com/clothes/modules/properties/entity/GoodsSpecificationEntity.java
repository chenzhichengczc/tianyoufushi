package com.clothes.modules.properties.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 *
 * @author fenghuang
 * @email 
 * @date 2019-08-16 11:19:33
 */
@TableName("goods_specification")
@Data

public class GoodsSpecificationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer goodsId;

	private String specification;

	private String value;

	private String picUrl;

	private Date createTime;

	private Date updateTime;

	private Integer deleted;

	@TableField(exist = false)
	@JsonProperty("childsCurGoods")
	private List<GoodsSpecificationEntity> goodsSpecificationEntity;

}
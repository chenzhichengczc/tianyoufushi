package com.clothes.modules.properties.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@TableName("shop_properties")
@Data
public class ShopPropertiesEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 *
	 */
	private Date dataAdd;
	/**
	 *
	 */
	private String name;
	/**
	 *
	 */
	private Integer paixu;
	/**
	 *
	 */
	private Integer propertyId;
	/**
	 *
	 */
	private String remark;
	/**
	 *
	 */
	private Integer userId;

	@TableField(exist = false)
	@JsonProperty(value = "childsCurGoods")
	private List<ShopPropertiesEntity> childsCurGoods;
}
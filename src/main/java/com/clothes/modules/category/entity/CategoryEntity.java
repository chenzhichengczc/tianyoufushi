package com.clothes.modules.category.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-08-14 15:48:07
 */
@TableName("category")
@Data
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Date dateAdd;
	/**
	 * 
	 */
	private Date dateUpdate;
	/**
	 * 
	 */
	private String icon;
	/**
	 * 
	 */
	private String isUse;
	/**
	 * 
	 */
	private String key;
	/**
	 * 
	 */
	private Integer level;
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
	private Integer pid;
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	private Integer userId;

}

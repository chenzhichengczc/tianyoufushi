package com.clothes.modules.config.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author fenghuang
 * @email
 * @date 2019-08-15 16:34:48
 */
@TableName("config")
@Data
public class ConfigEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 *
	 */
	private String remark;
	/**
	 *
	 */
	private String value;
	/**
	 *
	 */
	private String key;
}


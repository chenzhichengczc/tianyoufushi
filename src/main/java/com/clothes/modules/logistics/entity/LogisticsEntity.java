package com.clothes.modules.logistics.entity;

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
 * @date 2019-08-16 11:45:10
 */
@TableName("logistics")
@Data
public class LogisticsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 *
	 */
	private String isFree;
	/**
	 *
	 */
	private Integer feeType;
	/**
	 *
	 */
	private String feeTypeStr;
	/**
	 *
	 */
	private String details;


}
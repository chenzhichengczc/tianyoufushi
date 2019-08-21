package com.clothes.modules.pics.entity;

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
 * @date 2019-08-16 11:17:09
 */
@TableName("pics")
@Data
public class PicsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 *
	 */
	private Integer goodsid;
	/**
	 *
	 */
	private String pic;
	/**
	 *
	 */
	private Integer userid;


}
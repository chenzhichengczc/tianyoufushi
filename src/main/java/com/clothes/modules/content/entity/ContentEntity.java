package com.clothes.modules.content.entity;

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
 * @date 2019-08-16 11:18:11
 */
@TableName("content")
@Data
public class ContentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 * 商品介绍(富文本)
	 */
	private String content;
	/**
	 *
	 */
	private Integer goodsid;

}


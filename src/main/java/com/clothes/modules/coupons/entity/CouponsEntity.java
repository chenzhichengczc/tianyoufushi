package com.clothes.modules.coupons.entity;

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
 * @date 2019-08-15 14:53:24
 */
@TableName("coupons")
@Data
public class CouponsEntity implements Serializable {
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
	private Integer dateEndDays;
	/**
	 *
	 */
	private Integer dateEndType;
	/**
	 *
	 */
	private Integer dateStartType;
	/**
	 *
	 */
	private Date dateUpdate;
	/**
	 *
	 */
	private Float moneyHreshold;
	/**
	 *
	 */
	private Float moneyMax;
	/**
	 *
	 */
	private Float moneyMin;
	/**
	 *
	 */
	private String name;
	/**
	 *
	 */
	private Integer needScore;
	/**
	 *
	 */
	private Integer needSignedContinuous;
	/**
	 *
	 */
	private Integer numberGit;
	/**
	 *
	 */
	private Integer numberGitNumber;
	/**
	 *
	 */
	private Integer numberLeft;
	/**
	 *
	 */
	private Integer numberPersonMax;
	/**
	 *
	 */
	private Integer numberTotle;
	/**
	 *
	 */
	private Integer numberUsed;
	/**
	 *
	 */
	private Integer status;
	/**
	 *
	 */
	private String statusStr;
	/**
	 *
	 */
	private String type;
	/**
	 *
	 */
	private Integer dataEnd;
}



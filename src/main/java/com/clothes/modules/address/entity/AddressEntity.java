package com.clothes.modules.address.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-08-14 15:28:00
 */
@TableName("address")
@Data
public class AddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 * 默认地址
	 */
	private Integer isDefault;
	/**
	 * 联系人
	 */
	private String linkMan;
	/**
	 * 电话
	 */
	private String mobile;
	/**
	 * 省份
	 */
	private String provinceStr;
	/**
	 * 城市
	 */
	private String cityStr;
	/**
	 * 区域
	 */
	@TableField(value = "district_str")
	private String areaStr;
	/**
	 * 地址
	 */
	private String address;

	/**
	 * 邮编
	 */
	private String code;

	/**
	 * 微信openId
	 */
	private String openId;

	private String cityId;

	private String districtId;

	private String provinceId;
}

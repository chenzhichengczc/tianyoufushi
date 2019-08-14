package com.clothes.modules.category.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

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
	private Date dateadd;
	/**
	 * 
	 */
	private Date dateupdate;
	/**
	 * 
	 */
	private String icon;
	/**
	 * 
	 */
	private String isuse;
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
	private Integer userid;

	/**
	 * 设置：主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setDateadd(Date dateadd) {
		this.dateadd = dateadd;
	}
	/**
	 * 获取：
	 */
	public Date getDateadd() {
		return dateadd;
	}
	/**
	 * 设置：
	 */
	public void setDateupdate(Date dateupdate) {
		this.dateupdate = dateupdate;
	}
	/**
	 * 获取：
	 */
	public Date getDateupdate() {
		return dateupdate;
	}
	/**
	 * 设置：
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：
	 */
	public void setIsuse(String isuse) {
		this.isuse = isuse;
	}
	/**
	 * 获取：
	 */
	public String getIsuse() {
		return isuse;
	}
	/**
	 * 设置：
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * 获取：
	 */
	public String getKey() {
		return key;
	}
	/**
	 * 设置：
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setPaixu(Integer paixu) {
		this.paixu = paixu;
	}
	/**
	 * 获取：
	 */
	public Integer getPaixu() {
		return paixu;
	}
	/**
	 * 设置：
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 设置：
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * 获取：
	 */
	public Integer getUserid() {
		return userid;
	}
}

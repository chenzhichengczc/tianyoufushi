package com.clothes.modules.coupons.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-08-14 14:30:47
 */
@TableName("coupons")
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
	private Date dateadd;
	/**
	 * 
	 */
	private Integer dateenddays;
	/**
	 * 
	 */
	private Integer dateendtype;
	/**
	 * 
	 */
	private Integer datestarttype;
	/**
	 * 
	 */
	private Date dateupdate;
	/**
	 * 
	 */
	private Float moneyhreshold;
	/**
	 * 
	 */
	private Float moneymax;
	/**
	 * 
	 */
	private Float moneymin;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Integer needscore;
	/**
	 * 
	 */
	private Integer needsignedcontinuous;
	/**
	 * 
	 */
	private Integer numbergit;
	/**
	 * 
	 */
	private Integer numbergitnumber;
	/**
	 * 
	 */
	private Integer numberleft;
	/**
	 * 
	 */
	private Integer numberpersonmax;
	/**
	 * 
	 */
	private Integer numbertotle;
	/**
	 * 
	 */
	private Integer numberused;
	/**
	 * 
	 */
	private Integer status;
	/**
	 * 
	 */
	private String statusstr;
	/**
	 * 
	 */
	private String type;

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
	public void setDateenddays(Integer dateenddays) {
		this.dateenddays = dateenddays;
	}
	/**
	 * 获取：
	 */
	public Integer getDateenddays() {
		return dateenddays;
	}
	/**
	 * 设置：
	 */
	public void setDateendtype(Integer dateendtype) {
		this.dateendtype = dateendtype;
	}
	/**
	 * 获取：
	 */
	public Integer getDateendtype() {
		return dateendtype;
	}
	/**
	 * 设置：
	 */
	public void setDatestarttype(Integer datestarttype) {
		this.datestarttype = datestarttype;
	}
	/**
	 * 获取：
	 */
	public Integer getDatestarttype() {
		return datestarttype;
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
	public void setMoneyhreshold(Float moneyhreshold) {
		this.moneyhreshold = moneyhreshold;
	}
	/**
	 * 获取：
	 */
	public Float getMoneyhreshold() {
		return moneyhreshold;
	}
	/**
	 * 设置：
	 */
	public void setMoneymax(Float moneymax) {
		this.moneymax = moneymax;
	}
	/**
	 * 获取：
	 */
	public Float getMoneymax() {
		return moneymax;
	}
	/**
	 * 设置：
	 */
	public void setMoneymin(Float moneymin) {
		this.moneymin = moneymin;
	}
	/**
	 * 获取：
	 */
	public Float getMoneymin() {
		return moneymin;
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
	public void setNeedscore(Integer needscore) {
		this.needscore = needscore;
	}
	/**
	 * 获取：
	 */
	public Integer getNeedscore() {
		return needscore;
	}
	/**
	 * 设置：
	 */
	public void setNeedsignedcontinuous(Integer needsignedcontinuous) {
		this.needsignedcontinuous = needsignedcontinuous;
	}
	/**
	 * 获取：
	 */
	public Integer getNeedsignedcontinuous() {
		return needsignedcontinuous;
	}
	/**
	 * 设置：
	 */
	public void setNumbergit(Integer numbergit) {
		this.numbergit = numbergit;
	}
	/**
	 * 获取：
	 */
	public Integer getNumbergit() {
		return numbergit;
	}
	/**
	 * 设置：
	 */
	public void setNumbergitnumber(Integer numbergitnumber) {
		this.numbergitnumber = numbergitnumber;
	}
	/**
	 * 获取：
	 */
	public Integer getNumbergitnumber() {
		return numbergitnumber;
	}
	/**
	 * 设置：
	 */
	public void setNumberleft(Integer numberleft) {
		this.numberleft = numberleft;
	}
	/**
	 * 获取：
	 */
	public Integer getNumberleft() {
		return numberleft;
	}
	/**
	 * 设置：
	 */
	public void setNumberpersonmax(Integer numberpersonmax) {
		this.numberpersonmax = numberpersonmax;
	}
	/**
	 * 获取：
	 */
	public Integer getNumberpersonmax() {
		return numberpersonmax;
	}
	/**
	 * 设置：
	 */
	public void setNumbertotle(Integer numbertotle) {
		this.numbertotle = numbertotle;
	}
	/**
	 * 获取：
	 */
	public Integer getNumbertotle() {
		return numbertotle;
	}
	/**
	 * 设置：
	 */
	public void setNumberused(Integer numberused) {
		this.numberused = numberused;
	}
	/**
	 * 获取：
	 */
	public Integer getNumberused() {
		return numberused;
	}
	/**
	 * 设置：
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setStatusstr(String statusstr) {
		this.statusstr = statusstr;
	}
	/**
	 * 获取：
	 */
	public String getStatusstr() {
		return statusstr;
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
}

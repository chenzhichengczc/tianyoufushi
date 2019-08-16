package com.clothes.modules.score.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;


/**
 *
 *
 * @author fenghuang
 * @email
 * @date 2019-08-15 16:42:53
 */
@TableName("score")
@Data
public class ScoreEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 *
	 */
	private Integer scoreSignContinuous;

}

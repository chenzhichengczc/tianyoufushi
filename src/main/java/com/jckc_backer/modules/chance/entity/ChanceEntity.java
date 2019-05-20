package com.jckc_backer.modules.chance.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.jckc_backer.basic.BasicEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@TableName("custom_information")
@Data
@ApiModel("销售机会信息表")
public class ChanceEntity extends BasicEntity {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键",name = "chanceid")
   private Integer chanceid;

    @ApiModelProperty(value="机会名称",name="chanceName")
    @TableField(value = "chance_name")
    private String chanceName;

    @ApiModelProperty(value="客户名称",name="clientName")
    @TableField(value = "client_name")
    private String clientName;


  /*  @ApiModelProperty(value="机会类型",name="type")
    private String type;

    @ApiModelProperty(value="机会描述",name="cribe")
    private String cribe;*/

    @ApiModelProperty(value="机会来源",name="source")
    private String source;

 @ApiModelProperty(value="预计成交金额",name="money")
 private String money;

 @ApiModelProperty(value="机会阶段",name="stage")
 private String stage;

 @ApiModelProperty(value="成交可能性",name="possibility")
 private String possibility;

   /* @ApiModelProperty(value="成交日期",name="dateTime")
    @TableField(value = "date_time")
    private Date dateTime;





    @ApiModelProperty(value="备注",name="remarks")
    private String remarks;
*/
}

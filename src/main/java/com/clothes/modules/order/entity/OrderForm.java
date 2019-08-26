package com.clothes.modules.order.entity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.boot.json.GsonJsonParser;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/22 17:22
 * @description：
 * @modified By：
 * @version:
 */
@Data
public class OrderForm {

    /**
     * 订单号
     */
    private String orderOn;


    /**
     * payId
     */
    private String payId;

    /**
     * 商品信息字符串
     */
    private String goodsJsonStr;

    /**
     * 备注
     */
    private String remark;

    /**
     * 地址id
     */
    private Integer addressId;

    /**
     *  超时时间
     */
    private Long expireMinutes;

    /**
     * 是否累计
     */
    private Boolean calculate;

    @ApiModelProperty(value = "商品費用",name="goodsPrice")
    @TableField("goods_price")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "合计",name="actualPrice")
    @TableField("actual_price")
    private BigDecimal actualPrice;

    public static void main(String[] args) {
        String a = "[{\"goodsId\":115780,\"number\":1,\"specifications\":\"黑色:XL\",\"logisticsType\":0, \"inviter_id\":0},{\"goodsId\":115780,\"number\":1,\"specifications\":\"黑色:XL\",\"logisticsType\":0, \"inviter_id\":0}]";
        JSONArray jsonObject = JSONArray.parseArray(a);

        System.out.println("objects = " + jsonObject);
    }
}
